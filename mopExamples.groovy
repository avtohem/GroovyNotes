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
