let out = native com.jlambda.Builtins.println(String):void;
let tan = native java.lang.Math.tan(double):double;

out("Hello, World!");
out(tan(3.14));