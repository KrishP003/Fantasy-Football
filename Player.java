public class Player implements Comparable <Player>
{
    private final double average_pick;
    private final String name;
    private final String position;
    private final String team;
    private final int bye;
    private final double overall;
    private final double std_dev;
    private final double high_Rd;
    private final double low_Rd;
    private final int times_drafted;

    public Player(double pick, String n, String pos, String t, int off, double o, double dev, double hRd, double lRd, int d)
    {
        average_pick = pick;
        name = n;
        position = pos;
        team = t;
        bye = off;
        overall = o;
        std_dev = dev;
        high_Rd = hRd;
        low_Rd = lRd;
        times_drafted = d;
    }

    public double getAverage_pick()
    {
        return average_pick;
    }

    public String getName()
    {
        return name;
    }

    public String getPosition()
    {
        return position;
    }

    public String getTeam()
    {
        return team;
    }

    public int getBye()
    {
        return bye;
    }

    public double getOverall()
    {
        return overall;
    }

    public double getStd_dev()
    {
        return std_dev;
    }

    public double getHigh_Rd()
    {
        return high_Rd;
    }

    public double getLow_Rd()
    {
        return low_Rd;
    }

    public int getTimes_drafted()
    {
        return times_drafted;
    }

    public double getPickedPosDif()
    {
        int lowRd_round = (int) low_Rd;
        int highRd_round = (int) high_Rd;
        int lowRd_pick_num =(int)(low_Rd * 100) % 100;
        int highRd_pick_num=(int)(high_Rd * 100) % 100;
        return (lowRd_round - highRd_round) * 12 + (lowRd_pick_num - highRd_pick_num);
    }
    public int compareTo(Player b)
    {
        double num1 = overall;
        double num2 = b.getOverall();

        if(this.getPickedPosDif() < b.getPickedPosDif())
            return -1;
        if(this.getPickedPosDif() > b.getPickedPosDif())
            return 1;
         if(overall < b.getOverall())
            return -1;
         if(overall > b.getOverall())
            return 1;
         return 0;
    }

    public String toString()
    {
        return String.format("%-25s%-5s%5s%8s%8s%8s", name, position, team,""+low_Rd,""+high_Rd,""+times_drafted,""+overall);
    }
}

