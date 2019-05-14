import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = TEST ? new Scanner(INPUT) : new Scanner(System.in);
    Map<String, Integer> count = new LinkedHashMap<>();
    while (scanner.hasNextLine()) {
      String[] input = scanner.nextLine().trim().replaceAll("\\s+", " ").split("\\\\");
      String record = input[input.length - 1];
      if (count.containsKey(record)) {
        count.put(record, count.get(record) + 1);
      } else {
        count.put(record, 1);
      }
    }
    Object[] records = count.keySet().toArray();
    int start = records.length < 8 ? 0 : records.length - 8;
    for (int i = start; i < records.length; i++) {
      String[] tmp = ((String) records[i]).split("\\s");
      System.out
          .println(simplify(tmp[tmp.length - 2]) + " " + tmp[tmp.length - 1] + " " + count.get((String) records[i]));
    }
    scanner.close();
  }

  private static String simplify(String str) {
    int start = str.length() < 16 ? 0 : str.length() - 16;
    return str.substring(start, str.length());
  }

  private static final boolean TEST = true;
  private static final String INPUT = "G:\\rp\\onajqj\\maahmq 631\n" + "G:\\njfgjkcrh 641\n"
      + "G:\\co\\zk\\ao\\bxgxjfgrwckfxekeqro 629\n" + "G:\\mf\\si\\jmfdahkeffyjjsf 646\n" + "G:\\wn\\arefkiz 633\n"
      + "G:\\gpjleb\\cinhhx\\zjydgr\\njfgjkcrh 640\n" + "G:\\nwrrhx\\qyw\\bxgxjfgrwckfxekeqro 636\n"
      + "G:\\usgsl\\ywr\\tve\\cqekvaxypemktyurn 647\n" + "G:\\jftbig\\arefkiz 650\n" + "G:\\rgk\\cai\\arefkiz 640\n"
      + "G:\\tvse\\vs\\dhzrmy\\njfgjkcrh 634\n" + "G:\\coba\\qbs\\xagq\\njfgjkcrh 628\n"
      + "G:\\wnfsmf\\oxrvbv\\njfgjkcrh 632\n" + "G:\\khqx\\nv\\jmfdahkeffyjjsf 637\n"
      + "G:\\hm\\ra\\uaxckn\\bxgxjfgrwckfxekeqro 647\n" + "G:\\soq\\jmfdahkeffyjjsf 642\n"
      + "G:\\moxnw\\szxcdhlaytgj 639\n" + "G:\\avcop\\jd\\vwtrt\\njfgjkcrh 650\n" + "G:\\hou\\vv\\szxcdhlaytgj 631\n"
      + "G:\\uozkwd\\bxgxjfgrwckfxekeqro 650\n" + "G:\\jmfdahkeffyjjsf 650\n" + "G:\\hgoxms\\nwax\\szxcdhlaytgj 633\n"
      + "G:\\vylww\\zhh\\cqekvaxypemktyurn 643\n" + "G:\\njfgjkcrh 637\n" + "G:\\bfn\\dxwjje\\jmfdahkeffyjjsf 632\n"
      + "G:\\bxgxjfgrwckfxekeqro 634\n" + "G:\\gwuusj\\ized\\qq\\szxcdhlaytgj 646\n" + "G:\\arefkiz 644\n"
      + "G:\\zsw\\uewu\\arefkiz 634\n" + "G:\\ja\\zg\\njfgjkcrh 644\n" + "G:\\gfute\\ju\\wuy\\szxcdhlaytgj 636\n"
      + "G:\\mpgcx\\kcgi\\arefkiz 645\n" + "G:\\zayn\\jmfdahkeffyjjsf 648\n"
      + "G:\\kkplu\\avvw\\hbzmwj\\jmfdahkeffyjjsf 648\n" + "G:\\maahmq 631\n" + "G:\\hs\\xnto\\jmfdahkeffyjjsf 645\n"
      + "G:\\cqekvaxypemktyurn 633\n" + "G:\\maahmq 646\n" + "G:\\jmfdahkeffyjjsf 636\n"
      + "G:\\hbvm\\szxcdhlaytgj 642 ";
}
