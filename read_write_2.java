import java.io.*;
import java.util.*;

public class read_write_2 {
    public static void main(String[] args) throws IOException, FileNotFoundException, ArrayIndexOutOfBoundsException {
        int lc = 0;
        BufferedReader br = new BufferedReader(
                new FileReader("F:\\AVCOE\\College\\TE\\SEM-5\\SPOSL\\01-02\\pass 1\\src\\SYMTAB.txt"));
        ArrayList<TableRow> symtab = new ArrayList<>();
        String line;
        System.out.println("*****Symbol Table*****");
        while ((line = br.readLine()) != null) {
            String parts[] = line.split("\\s+");
            symtab.add(new TableRow(parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[0])));
            System.out.println(parts[1] + " " + Integer.parseInt(parts[2]) + " " + Integer.parseInt(parts[0]));
        }
        br.close();
        br = new BufferedReader(
                new FileReader("F:\\AVCOE\\College\\TE\\SEM-5\\SPOSL\\01-02\\pass 1\\src\\IC.txt"));
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("op.txt"));
        String code;
        System.out.println("*****OUTPUT*****");
        while ((line = br.readLine()) != null) {
            String parts[] = line.split("\\s+");
            if (parts[0].contains("DL,02")) {
                int constant = Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
                lc = lc + constant;
            }
            if (parts[0].contains("AD") || (parts[0].contains("DL,02"))) {
                //ssbw.write("\n");
            } else if (parts.length == 1) {
                int opcode = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                code = String.format("%02d", opcode) + "\t0\t" + String.format("%03d", 0) ;
                bw.write(code);
            } else if (parts.length == 2) {
                if (parts[0].contains("DL,01")) {
                    int constant = Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
                    code = String.format("%02d", 0) + "\t0\t" + String.format("%03d", constant);
                    bw.write(/*lc + ")" +*/ code + "\n");
                    System.out.println(/*lc + ")" +*/ code);
                } else if (parts[0].contains("IS")) {
                    int opcode = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                    int symindex = Integer.parseInt(parts[1].replaceAll("[^0-9]", ""));
                    int add = symtab.get(symindex - 1).getAddress();
                    code = String.format("%02d", opcode) + "\t0\t" + String.format("%03d", add);
                    bw.write(/*lc + ")" +*/ code + "\n");
                    System.out.println(/*lc + ")" +*/ code);
                }
            } else if (parts.length == 3) {
                int opcode = Integer.parseInt(parts[0].replaceAll("[^0-9]", ""));
                int regcode = Integer.parseInt(parts[1]);
                int symindex = Integer.parseInt(parts[2].replaceAll("[^0-9]", ""));
                int add = symtab.get(symindex - 1).getAddress();
                code = String.format("%02d", opcode) + "\t" + regcode + "\t" + String.format("%03d", add);
                bw.write(/*lc + ")" + */code +"\n");
                System.out.println(/*lc + ")" +*/ code);
            }
            lc++;
        }
        br.close();
        bw.close();
    }
}