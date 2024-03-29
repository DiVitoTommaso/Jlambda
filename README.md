# Jlambda
Minimal functional programming language like lambda calculus written in java with:
1) Higher-order function support
2) Partial functions
3) Static scoping
4) Dynamic type checking
5) Shadowing support (for let and let-in)
6) Possibility to use native java function and possibility to treat them as normal function of this language (they support partial application, but you can work only with primitives of the language (int, float, string, double, boolean or their super classes) as parameters and return type must be instance of (int, float, string, double, boolean)) or function will raise an error
7) Free variables and fresh variables support for functions
8) 'If' statement for expression selection with only boolean guards support
9) 'Let' support to assign a name to an expression, function or result of a function application
10) 'Let-in' support to assign a name visible only in the expression which follows 'in' locally (as OCaml)
11) 'Call by name' and 'Call by value' function support using ``` f(x) | by name ``` or ``` f(x) | by value ``` 
12) 'Step-By-Step' support for expression evaluation with details using ``` f(x) | by name with steps ``` or ``` f(x) | by value with steps ```
13) Vars bounds analysis (language uses static scoping so the enviroment for the function will be the enviroment available at declaration, you get errors for unbound names (variables) during function delaration. (functions declarations with free variable won't evaluate)
14) Recursion not supported natively. 'Let' and 'Let-in' function declaration can't see their name during declaration (Consider using 'Y' combinator)
15) Toy language not for real usage

# Release
- Download Java 19+ (Latest suggested): https://www.oracle.com/it/java/technologies/downloads/#java19
- Download the release executable file: https://github.com/DiVitoTommaso/Jlambda/releases/tag/Jlambda

# How To Run
1) *Write in your console ```java -jar path/to/Jlambda.jar ``` replacing "path/to/Jlambda.jar" with the path of the downloaded release file*
2) You can pass a file as argument when you run the Jlambda class as main class and this will evaluate the code of the file and will open a console where you can see errors, well done evaluations of the file and possibility to evaluate manual code at runtime (no reset possible)
3) You can instantiate from external project as many interpreters as you want you need only to instantiate the JlambdaInterpreter class
4) You can register native java methods using the method register of the interpreter instance (method is visible only to that instance)
5) You can evaluate code using eval method of the interpreter instance (multiple expressions must be separated by ';')
6) You can reset the environment of the interpreter instance using the method reset
7) Builtin class contains some useful native method that can be registered to the interpreter 
8) Evaluation will extend global enviroment associated to the interpreter it won't reset at the end of the eval method call automatically.
9) If an error occur the environment created before the error will remain and an error will be raised
10) Each interpreter is synchronized. Only one thread at a time can use methods of an interpreter instance
11) Use ';' to concatenate expressions during eval (Ex. let v1 = 10; let v2 = 20)
12) The grammar of this language can be found in the same directory of the interpreter class (Jlambda.g4) in ANTLR form

# As Library
If you want to use the interpreter as a library:
1) You can add the 'release jar' as library
2) Create an instance of JLambdaInterpreter class
3) Use builtin methods of the interpreter to create your enviroment and evaluate your code as a string.

# Libraries requirements
*Libraries are no needed if you use the release file*

- ANTLR4 for java: https://www.antlr.org/download.html (for jlambda lexer and parser)
- Apache Maven: https://maven.apache.org/download.cgi (useful for building project, but not necessary to run it)

# Expression example
```
let v = fun x.(x); # ok #
let unbound = fun x.g(x); # ok 'g' will be considered as a free variable #
let Ω = fun x.(x x); #  Ω(Ω) infinite application will print an error and will go to evaluate the next expression #
let higherOrderFun = fun x.(fun y.(x y)) # use ; to evaluate multiple expression, but last expression doesn't need ';' at the end #

let equal = native java.util.Objects.equals(Object,Object):boolean; # register native java function (works only if native loading is enabled) #
let res = let one = 1 in equal(one)(one); # check equality using native java function #

let five1 = higherOrderFun fun x.(x) 5; # invocation can be done without parentesis #
let five2 = higherOrderFun(fun x.(x))(5); # invocation can be done with parenteses, but if you use parenteses each invocation must have only 1 parameter #
let res = let one = 1 in v(one) # extend enviroment with 'one' only for this evaluation and the apply 'one' to 'v' #

let byValueWithSteps = fun x.(fun y.(fun z.(if x then y else z))) (true) 1 (fun x.(x x) (fun x.(x x))) | by value with steps # infinite application error #
let byNameWithSteps = fun x.(fun y.(fun z.(if x then y else z))) (true) 1 (fun x.(x x) (fun x.(x x))) | by name with steps # This will print: **val - => 1** #
```

# Factorial in Lambda calculus
```
let mul = native com.jlambda.Builtin.mul(int,int):int;
let sub = native com.jlambda.Builtin.sub(int,int):int;
let eq = native com.jlambda.Builtin.equals(int, int):boolean;

let Y = fun f.(fun x.(x x)(fun x.(f(fun y.(x(x)(y)))))); # Y combinator to emulate recursion #
let fact = fun f.(fun x.(if eq(x)(1) then 1 else mul(x)(f(sub(x)(1))))); # Factorial function definition without recursion support #
Y(fact)(10); # evaluate factorial of 10. This will print: **val - => 3628800**  #
Y fact 10; # Same as above without parenteses. parenteses are needed for native functions with no args or when you need to pass a complex expression as expression #
```
**Note: Function body must be enclosed between paranteses '()' to avoid ambiguity**
