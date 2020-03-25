class TestMOP{
    def existMeth(){
        println "Call existed method"   
    }
    def methodMissing(String name, Object args){
        println "Call missied method - $name"
        println "with args:"
        args.each{
            print " $it"
        }
    }
}

TestMOP item = new TestMOP()
item.existMeth()
item.someMeth()
item.someMeth1("str")
item.someMeth2("str1", "str2")

// modif methodMissing for existing (any) class

String.metaClass{
    methodMissing = {String name, args ->
                        println "No such method - ${name} and args $args"
                        println "work with - ${delegate}"}
}

String df = "dff"
println df
println df.tt()
println df.tt(1,2, 'd')


println "testString".mm("testArgsString")
