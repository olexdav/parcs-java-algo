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
      ArrayList<Integer> integers = new ArrayList<>();
      try {
          Path filePath = Paths.get("input-100000.txt");
          Scanner scanner = new Scanner(filePath);
          while (scanner.hasNext()) {
              if (scanner.hasNextInt()) {
                  integers.add(scanner.nextInt());
              } else {
                  scanner.next();
              }
          }
      } catch (IOException e) {e.printStackTrace(); return;}

      point p1 = info.createPoint();
      channel c1 = p1.createChannel();
      p1.execute("Algo");
      c1.write(integers);

      System.out.println("Waiting for result...");
      List<Integer> r = (List<Integer>)c1.readObject();
      System.out.println("Result found!");
      System.out.println("First 10 values:");
      System.out.println(r.subList(0, 10));
      System.out.println("Last 10 values:");
      System.out.println(r.subList(r.size()-10, r.size()));

      //System.out.println("F"+n+"="+r);
      //try{
      //    PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("App.res")));
      //    out.println(r);
      //    out.close();
      //} catch (IOException e) {e.printStackTrace(); return;}
    }
}
