# Jlambda
Minimal functional programming language like lambda calculus written in java with:
1) Higher-order function support
2) Partial functions
3) Static scoping
4) Shadowing support (for let and let-in)
5) Possibility to load native java function and possibility to treat them as normal function of this language (they partial application support, but you can work only with primitives of the language (int, float, string, double, boolean or their super classes) as parameters and return type must be instance of (int, float, string, double)) or function will raise an error
6) Let to assign a name to an expression, function or result of a function application
7) Let-in to assign a name visible only in the expression which follows 'in' locally (as ocaml)
8) No static analysis (language uses static scoping so the enviroment for the function will be the enviroment available at declaration, but you get errors for unbound names (variables) only during function application not during declaration. (functions with free variable will compile, but they'll fail at invocation time)
9) Language is interpreted so evaluation will take very long time
10) Functions delcarations and let in create copy of the enviroment to be able to extend them using static scoping, shadowing, and local declarations => memory usage very high
11) Toy language not for real usage

# How To

1) You can run the project using the class Jlambda in the [main.java.com.jlambda.lang] directory as a normal maven project.
2) You can pass a file as argument when you run the Jlambda class as main class and this will evaluate the code of the file and will open a console where you can see errors, well done evaluations of the file and possibility to evaluate manual code at runtime
3) You can find a syntax example file in the lang directory [main.java.com.jlambda.lang]
4) Don't edit eval method, register method or env field (hashmap) or interpreter will break
5) You can call the interpreter to register native java methods or evaluate jlambda code from external project using the methods of Jlambda class (Jlambda.eval(), Jlambda.register())
6) JLBuiltin class contains some useful native method that can be registered to the interpreter 
7) Evaluation will extend global enviroment and it won't reset at the end of the eval method call
8) Only one thread at time can access the interpreter 

# Libraries requirements

- ANTLR4 for java: https://www.antlr.org/download.html (for jlambda lexer and parser)
- Apache Maven: https://maven.apache.org/download.cgi (useful for building project, but not necessary to run it)
