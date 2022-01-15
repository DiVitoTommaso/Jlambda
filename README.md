# Jlambda
Minimal functional programming language like lambda calculus written in java with:
1) Higher-order function support
2) Partial functions
3) Static scoping
4) Dynamic type checking
5) Shadowing support (for let and let-in)
6) Possibility to load native java function and possibility to treat them as normal function of this language (they support partial application, but you can work only with primitives of the language (int, float, string, double, boolean or their super classes) as parameters and return type must be instance of (int, float, string, double, boolean)) or function will raise an error
7) 'If' statement for expression selection with only boolean guards support
8) 'Let' support to assign a name to an expression, function or result of a function application
9) 'Let-in' support to assign a name visible only in the expression which follows 'in' locally (as ocaml)
10) Static analysis (language uses static scoping so the enviroment for the function will be the enviroment available at declaration, you get errors for unbound names (variables) during function delaration. (functions with free variable won't compile)
11) Recursion not supported natively. 'Let' and 'Let-in' function declaration can't see their name during declaration. (Consider using 'Y' combinator)
12) Language is interpreted so evaluation will be slow
13) Functions declarations and let in create copy of the enviroment to be able to extend them using static scoping, shadowing, and local declarations => memory usage very high
14) Toy language not for real usage

# How To

1) You can run the project using the Jlambda class in the [main.java.com.jlambda.builtin] directory as a normal maven project.
2) You can pass a file as argument when you run the Jlambda class as main class and this will evaluate the code of the file and will open a console where you can see errors, well done evaluations of the file and possibility to evaluate manual code at runtime (no reset possible)
3) Don't edit eval method, register method or env field (hashmap) or interpreter will break
4) You can instantiate from external project as many interpreters as you want you need only to instantiate the JlambdaInterpreter class
5) You can register native java methods using the method register of the interpreter instance (method is visible only to that instance)
6) You can evaluate code using eval method of the interpreter instance (multiple expressions must be separated by ';')
7) You can reset the environment of the interpreter instance using the method reset
8) JLBuiltin class contains some useful native method that can be registered to the interpreter 
9) Evaluation will extend global enviroment associated to the thread who invoked the expression evaluation and it won't reset at the end of the eval method call.
10) If an error occur the environment created before the error will remain and an error will be raised
11) Each interpreter is synchronized. Only one thread at a time can use methods of an interpreter instance
12) The grammar of this language can be found in the same directory of the interpreter class (Jlambda.g4) in ANTLR form

# Libraries requirements

- ANTLR4 for java: https://www.antlr.org/download.html (for jlambda lexer and parser)
- Apache Maven: https://maven.apache.org/download.cgi (useful for building project, but not necessary to run it)

# Expression example
```
let if = fun c -> fun then -> fun else -> (c(then)(else));
let Ω = fun x -> (x(x));#  Ω(Ω) infinite application will print an error and will go to evaluate the next expression #
let one = 1 in equal(one)(one) # assuming equal is native registered; #
```
