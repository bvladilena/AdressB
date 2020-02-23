import java.util.HashMap;
import java.util.Map;

public class Adr {

    class AdrNew {
        public int numberH;
        public int numberF;
        public String numberS;

        AdrNew(String numberS, int numberH, int numberF) {
            this.numberS = numberS;
            this.numberH = numberH;
            this.numberF = numberF;
        }


        public String toString() {
            return "street" + numberS + "house" + numberH + "flat" + numberF;
        }
    }

    class Name {
        public String name;

        Name(String name) {
            this.name = name;
        }

        public String toString() {
            return "name" + name + " ";
        }
    }
}


