import java.io.*;
import parcs.*;
import java.util.*; 
import java.nio.file.*;

public class App implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("App.jar");
        (new App()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
      List<Integer> integers = new ArrayList<>();
      try {
          //ints = Files.lines(Paths.get("input-100.txt"))
          //        .mapToInt(Integer::parseInt).toArray();
          Path filePath = Paths.get("input-100.txt");
          Scanner scanner = new Scanner(filePath);
          while (scanner.hasNext()) {
              if (scanner.hasNextInt()) {
                  integers.add(scanner.nextInt());
              } else {
                  scanner.next();
              }
          }
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
      Collections.sort(integers);
      System.out.println("Result found:");
      System.out.println(integers);

      //System.out.println("F"+n+"="+r);
      //try{
      //    PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("App.res")));
      //    out.println(r);
      //    out.close();
      //} catch (IOException e) {e.printStackTrace(); return;}
    }
}
