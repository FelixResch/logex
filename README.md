Logex Parser
===

Usage
---

```
Usage: logex [-dhsvz] [--suppress-ast] [<expression>]...
      [<expression>]...       The parts of the logical expression
      --suppress-ast          Don't print the AST
  -d, --debug                 Prints debug information
  -h, --help                  Prints this help message and exits
  -s, --silent                Only print the table
  -v, --version               Prints the version of the logex library and the
                                client implementation
  -z, --zeros-first           If the 0s should start at the bottom
```

Operators
---

| Name | Description | Unicode Character | Short Syntax | Long Syntax |
| ---- | ----------- | ----------------- | ------------ | ----------- |
| Not | **NOT** A | `¬` | `!` | `-not` |
| And | `A` **AND** `B` | `∧` | `&` | `-and` |
| Nand | `¬ (A ∧ B)` | `↓` | `!&` | `-nand` |
| Or | `A` **OR** `B` | `∨` | `|` | `-or` |
| Nor | `¬ (A ∨ B)` | `↑` | `!|` | `-nor` |
| Xor | `A` **exclusive or** `B` | `⊗` | | `-xor` |
| Implication | `A` **implies** `B` | `⇒` | `=>`, `->` | `-im`, `-impl`, `-implies`, `-implication` |
| Equivalence | `A` **equivalent** `B` | `⇔` | `=` | `-eq`, `-equal`, `-equals` |

For CLI usage, the use of the *Short Syntax* is probably best, output of a logix expression is always in Unicode representation.

Roadmap
--- 

- [ ] Better README and Documentation
- [ ] WebService
- [ ] Simpler operator detection
- [ ] Expression optimization
- [ ] ITE - creation
- [ ] More output options
- [ ] KNF/DNF
- [ ] NAND/NOR Form output

Attributions
---

- [remkop/picocli](https://github.com/remkop/picocli) Annotation-based Java command line parsing library. Usage help with ANSI colors. Autocomplete. Nested subcommands. Easily included as source to avoid adding dependencies. (Apache 2) 