import java.io.*;
import parcs.*;
import java.util.stream.IntStream;

public class App implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("App.jar");
        (new App()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
      long n;
      try {
          /*byte[] buf = new byte[200];
          System.out.print("Enter n: ");
          System.in.read(buf);
          n=new Long(new String(buf).trim()).longValue();*/

          BufferedReader in = new BufferedReader(new FileReader(info.curtask.findFile("App.data")));
          n = new Long(in.readLine()).longValue();
      } catch (IOException e) {e.printStackTrace(); return;}

      point p1 = info.createPoint();
      channel c1 = p1.createChannel();
      p1.execute("Algo");
      List<Integer> range = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
      c1.write(range);

      System.out.println("Waiting for result...");
      long r = c1.readLong();
      System.out.println("Result found.");

      //System.out.println("F"+n+"="+r);
      try{
          PrintWriter out = new PrintWriter(new FileWriter(info.curtask.addPath("App.res")));
          out.println(r);
          out.close();
      } catch (IOException e) {e.printStackTrace(); return;}
    }
}
