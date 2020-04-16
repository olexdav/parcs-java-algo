import parcs.*;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

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
            point[] points = new point[parts];
            channel[] channels = new channel[parts];
            for (int i = 0; i < parts; i++) { // Split tasks between workers
                int l, r;
                l = i*step;
                r = l + step;
                if (r > range.size())
                    r = range.size();
                points[i] = info.createPoint();
                channels[i] = points[i].createChannel();
                points[i].execute("Algo");
                channels[i].write(new ArrayList<Integer>(range.subList(l, r)));
            }
            //result = 1; 
            BigInteger result = new BigInteger("1"); // Gather results
            BigInteger channel_res;
            for (int i = 0; i < parts; i++)
                channel_res = new BigInteger((String)channels[i].readObject());
                result = result.multiply(channel_res);
        }
        info.parent.write(result.toString());
    }
}
