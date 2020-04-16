import java.io.*;
import parcs.*;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("App.jar");
        (new App()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
      int[] ints;
      try {
          ints = Files.lines(Paths.get("input-100.txt"))
                  .mapToInt(Integer::parseInt).toArray();
      } catch (IOException e) {e.printStackTrace(); return;}

      //point p1 = info.createPoint();
      //channel c1 = p1.createChannel();
      //p1.execute("Algo");
      //ArrayList<Integer> range = new ArrayList<Integer>((int)n);
      //for (int i=1; i<=n; i++) {
      //      range.add(i);
      //}
      //c1.write(range);

      System.out.println("Waiting for result...");
      //String r = (String)c1.readObject();
      System.out.println("Result found:");
      System.out.println(ints);

      //System.out.println("F"+n+"="+r);
      //try{
      //    PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("App.res")));
      //    out.println(r);
      //    out.close();
      //} catch (IOException e) {e.printStackTrace(); return;}
    }
}
