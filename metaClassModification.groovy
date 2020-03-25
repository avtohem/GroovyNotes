//Class static and usual metthods add

Integer.metaClass.static.answer = {-> 42}
Integer.metaClass.answer1 = {-> 43}
assert Integer.answer() == 42
println 1.answer()
println Integer.answer()
println 1.answer1()
