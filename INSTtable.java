import java.util.*;

public class INSTtable {
    HashMap<String, Integer> AD, DL, IS, RG;

    public INSTtable() {
        AD = new HashMap<String, Integer>();
        DL = new HashMap<String, Integer>();
        IS = new HashMap<String, Integer>();
        RG = new HashMap<String, Integer>();

        AD.put("START", 01);
        AD.put("END", 02);
        AD.put("ORIGIN", 03);
        AD.put("EQU", 04);
        AD.put("LTORG", 05);

        DL.put("DC", 01);
        DL.put("DS", 02);

        IS.put("STOP", 00);
        IS.put("ADD", 01);
        IS.put("SUB", 02);
        IS.put("DIV", 03);
        IS.put("MOVEM", 04);
        IS.put("MOVER", 05);
        IS.put("COMP", 06);
        IS.put("BC", 07);
        IS.put("MUL", 8);
        IS.put("READ", 9);
        IS.put("PRINT", 10);

        RG.put("AREG", 01);
        RG.put("BREG", 02);
        RG.put("CREG", 03);
        RG.put("DREG", 04);
    }

    public String getType(String s) {
        s = s.toUpperCase();

        if (AD.containsKey(s))
            return "AD";
        else if (DL.containsKey(s))
            return "DL";
        else if (IS.containsKey(s))
            return "IS";
        else if (RG.containsKey(s))
            return "RG";
        else
            return "";
    }

    public int getCode(String s) {
        s = s.toUpperCase();

        if (AD.containsKey(s))
            return AD.get(s);
        else if (DL.containsKey(s))
            return DL.get(s);
        else if (IS.containsKey(s))
            return IS.get(s);
        else if (RG.containsKey(s))
            return RG.get(s);
        return 0;
    }

}
