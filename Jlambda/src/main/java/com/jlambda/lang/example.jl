let if = fun c -> fun then -> fun else -> (c(then)(else))
let Y = fun f -> (fun x -> (f (x(x)))(fun x -> (f (x(x)))))
let one = 1 in ==(one)(one) # assuming == is native defined #