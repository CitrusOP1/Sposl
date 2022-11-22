
import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Pass1 {
    static List<MNT> mnt = new LinkedList<MNT>();
    static List<String> ala = new LinkedList<String>();
    static List<String> mdt = new LinkedList<String>();
    static int mntc = 0;
    static int mdtc = 0;
    static BufferedReader br;
    static BufferedWriter bw, BWS;

    public static void main(String[] args) throws Exception, IOException {
        String line;
        br = new BufferedReader(new FileReader("F:\\AVCOE\\College\\TE\\SEM-5\\SPOSL\\03-04\\Macro Pass 1\\src\\IP"));
        bw = new BufferedWriter(new FileWriter("OP.txt"));

        while ((line = br.readLine()) != null) {
            String parts[] = line.split("\\s+");

            if (parts[0].equals("MACRO")) {
                process_def(line);
            } else {
                bw.write(line + "\n");
            }
        }

        System.out.println("ALA");
        printala();
        System.out.println("MNT");
        printmnt();
        System.out.println("MDT");
        printmdt();
        bw.close();
    }

    static void printala() throws IOException {
        BWS = new BufferedWriter(new FileWriter("ALA.txt"));
        int i = 0;
        for (String l : ala) {
            System.out.println(i + " " + l);
            BWS.write(l + "\n");
            // bw.write(i+" "+l+"\n");
            i++;
        }
        out.println(" ");
        BWS.close();
    }

    static void printmnt() throws IOException {
        BWS = new BufferedWriter(new FileWriter("MNT.txt"));
        int i = 0;
        for (MNT l : mnt) {
            System.out.println(i + " " + l.macro_name + " " + l.mdtc);
            BWS.write(l.macro_name + " " + l.mdtc + "\n");
            // bw.write(i+" "+l.macro_name+" "+l.mdtc+"\n");
            i++;
        }
        out.println();
        BWS.close();
    }

    static void printmdt() throws IOException {
        BWS = new BufferedWriter(new FileWriter("MDT.txt"));
        int i = 0;
        for (String l : mdt) {
            System.out.println(i + " " + l);
            // bw.write(i+" "+l+"\n");
            BWS.write(l + "\n");
            i++;
        }
        out.println();
        BWS.close();
    }

    static void process_def(String line) throws IOException {
        String l = br.readLine();
        String tk[] = l.split(" ");
        mnt.add(new MNT(tk[0], mdtc));
        mntc++;
        String args[] = tk[1].split(",");
        for (int i = 0; i < args.length; i++) {
            ala.add(args[i]);

        }
        mdt.add(l);
        mdtc++;
        while (!l.equalsIgnoreCase("MEND")) {
            int ind;
            int i = 0;
            String opline = "";
            l = br.readLine();
            if ((ind = l.indexOf("&")) > 0) { // System.out.print(l);
                String wrd[] = l.split("\\s+");
                opline = opline + " " + wrd[0];
                String margs[] = wrd[1].split(",");
                opline = opline + " " + margs[0];
                // System.out.println(margs.length);
                while (i < margs.length) {
                    if (margs[i].startsWith("&")) {
                        ind = ala.indexOf(margs[i]);
                        opline = opline + " #" + ind;
                    }
                    i++;
                }
            } else {
                opline = l;
            }
            mdt.add(opline);
            mdtc++;
        }
    }
}

/*
 * import java.io.*;
 * import java.util.*;
 * 
 * class MNT
 * {
 * String Macro_name;
 * int MDTC;
 * public MNT(String n, int MDP)
 * {
 * Macro_name = n;
 * MDTC = MDP;
 * }
 * }
 * 
 * public class PASS1
 * {
 * static List<MNT>mnt = new LinkedList<MNT>();
 * static List<String> ALA = new LinkedList<String>();
 * static List<String> MDT = new LinkedList<String>();
 * 
 * static int MDTC = 0;
 * static int MNTC = 0;
 * static BufferedReader BR;
 * static BufferedWriter BW,BWS;
 * 
 * public static void main(String[] args)
 * throws Exception
 * {
 * BR = new BufferedReader(new
 * FileReader("C:\\Users\\Owner\\eclipse-workspace\\Pass 1\\src\\PASS1\\IP"));
 * BW = new BufferedWriter(new FileWriter("OP.txt"));
 * String Line;
 * while((Line = BR.readLine())!=null)
 * {
 * if(Line.equalsIgnoreCase("MACRO"))
 * {
 * Process_Def(Line);
 * }
 * 
 * else
 * {
 * BW.write(Line+"\n");
 * }
 * }
 * System.out.println("MNT");
 * print_MNT();
 * System.out.println("ALA");
 * print_ALA();
 * System.out.println("MDT");
 * print_MDT();
 * BW.close();
 * }
 * 
 * static void print_ALA() throws Exception
 * {
 * BWS = new BufferedWriter(new FileWriter("ALA.txt"));
 * int i=0;
 * for(String l:ALA)
 * {
 * System.out.println(i+" "+l);
 * BWS.write(i+" "+l+"\n");
 * i++;
 * }
 * System.out.println();
 * BWS.close();
 * }
 * static void print_MNT() throws Exception
 * {
 * BWS = new BufferedWriter(new FileWriter("MNT.txt"));
 * int i=0;
 * for(MNT l:mnt)
 * {
 * System.out.println(i+" "+l.Macro_name+" "+l.MDTC);
 * BWS.write(i+" "+l.Macro_name+" "+l.MDTC+"\n");
 * i++;
 * }
 * System.out.println();
 * BWS.close();
 * }
 * static void print_MDT() throws Exception
 * {
 * BWS = new BufferedWriter(new FileWriter("MDT.txt"));
 * int i=0;
 * for(String l:MDT)
 * {
 * System.out.println(i+" "+l);
 * BWS.write(l+"\n");
 * i++;
 * }
 * System.out.println();
 * BWS.close();
 * }
 * 
 * static void Process_Def(String Line)throws IOException
 * {
 * String L = BR.readLine();
 * String TK[] = L.split(" ");
 * mnt.add(new MNT(TK[0],MDTC));
 * MNTC++;
 * String Arg[] = TK[1].split(",");
 * for(int i=0; i<Arg.length; i++)
 * {
 * ALA.add(Arg[i]);
 * }
 * MDT.add(L);
 * MDTC++;
 * 
 * while(!L.equalsIgnoreCase("MEND"))
 * {
 * int j=0, Index;
 * String OPLINE = "";
 * L = BR.readLine();
 * if((Index = L.indexOf("&"))>0)
 * {
 * String word[]=L.split(" ");
 * OPLINE = OPLINE+" " +word[0];
 * String Margs[] = word[1].split(",");
 * OPLINE = OPLINE+" "+Margs[0];
 * 
 * while(j<Margs.length)
 * {
 * if(Margs[j].startsWith("&"))
 * {
 * Index = ALA.indexOf(Margs[j]);
 * OPLINE = OPLINE + " #" + Index;
 * }
 * j++;
 * }
 * }
 * else
 * {
 * OPLINE = L;
 * }
 * MDT.add(OPLINE);
 * MDTC++;
 * }
 * }
 * }
 */