import parcs.*;
import java.lang.Math;
import java.util.List;

public class Algo implements AM{
    public void run(AMInfo info){
        //long n,r1,r2,r;
        long result;
        List<Integer> range = (List<Integer>)info.parent.readObject();
        if (range.size() == 0)
            result = 1;
        else if (range.size() == 1)
            result = range.get(0);
        else {
            int parts = 2;
            int step = (int)(Math.ceil((float)(range.size()) / (float)(parts)));
            point* points = new point[parts];
            channel* channels = new channel[parts];
            for (int i = 0; i < parts; i++) { // Split tasks between workers
                int l, r;
                l = i*step;
                r = l + step;
                if (r > range.size())
                    r = range.size();
                points[i] = info.createPoint();
                channels[i] = points[i].createChannel();
                points[i].execute("Algo");
                channels[i].write(new List(range.subList(l, r)));
            }
            result = 1; // Gather results
            for (int i = 0; i < parts; i++)
                result *= channels[i].readLong();
        }
        info.parent.write(result);
    }
}
