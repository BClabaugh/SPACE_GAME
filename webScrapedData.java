import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class fakeMain{
    public static void main(String[] args) throws FileNotFoundException {
        webScrapedData s = new webScrapedData();
        System.out.println(s.getDistanceToSun() + "\n" + s.getMoonPhase());
    }
}

public class webScrapedData{
//https://stackoverflow.com/questions/10097491/call-and-receive-output-from-python-script-in-java
        private String distanceToSun;
        private String moonPhase;
        public webScrapedData() throws FileNotFoundException {
            distanceToSun = answerForSun();
            moonPhase = answerForMoon();
        }

        public String answerForSun() throws FileNotFoundException {
            String s;
            String m = "";
            try {
                Process p = Runtime.getRuntime().exec("python EarthsDistanceFromSun.py");
                BufferedReader stdInput = new BufferedReader(new
                        InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new
                        InputStreamReader(p.getErrorStream()));
                while ((s = stdInput.readLine()) != null) {
                    m += s;
                }
            } catch (IOException e) {
                throw new FileNotFoundException("");
            }
            return m;

        }

    public String answerForMoon() throws FileNotFoundException {
        String s;
        String m = "";
        try {
            Process p = Runtime.getRuntime().exec("python MoonPhase.py");
            BufferedReader stdInput = new BufferedReader(new
                    InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new
                    InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                m += s;
            }
        } catch (IOException e) {
            throw new FileNotFoundException("");
        }
        return m;
    }

    public String getDistanceToSun(){
            return distanceToSun;
    }

    public String getMoonPhase(){
        return moonPhase;
    }




}