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
| Or | `A` **OR** `B` | `∨` | &verbar; | `-or` |
| Nor | `¬ (A ∨ B)` | `↑` | `!`&verbar; | `-nor` |
| Xor | `A` **exclusive or** `B` | `⊗` | | `-xor` |
| Implication | `A` **implies** `B` | `⇒` | `=>`, `->` | `-im`, `-impl`, `-implies`, `-implication` |
| Equivalence | `A` **equivalent** `B` | `⇔` | `=` | `-eq`, `-equal`, `-equals` |

For CLI usage, the use of the *Short Syntax* is probably best, output of a logix expression is always in Unicode representation.

Build
---

To build this program you can either use the gradle distribution distributed with this service, or use your own gradel implementation.

If you want to use the packaged gradle distribution replace all occurences of `gradle` with `./gradlew` (Linux/Unixoids) or `gradlew.bat` (Windows).

```bash
gradle generateArtifactInfoClass
gradle logex-cli:fatJar
```

You can then use the generated jar in `logex-cli/build/libs/` to run logex.

```bash
java -jar [path-to-jar] [arguments] 
```

To simply call logex you can create a script file in your path. For systems that use `bash` you can use a script like this to run logex directly from the command line. Please note that java needs to be on your path as well.

```bash
#!/usr/bin/env bash

java -jar (path-to-jar) "$@"
```

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