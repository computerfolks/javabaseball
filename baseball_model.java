import java.io.*;
import java.util.*;
import java.math.*;

public class baseball_model {

    /**
     *
     * @author jacobweissman
     */
    // don't forget to remove " from fangraphs files
    public class Analytics_Baseball {

        public static class Batter {
            public String last_name;
            public String first_name;
            public String team_name;
            public double xwoba_constant = 0.316; // .85 * league average of 0.316
            public double barrel_constant = 5.1; // .85 * rough league average of 6
            public double runs_average = 4.52; // average
            public double pa_total;
            public double pa_total_weighted;
            public double off;
            public double xwoba_runs_scale;
            public double xwoba;
            public double bsr;
            public double def;
            public double bbe_total;
            public double bbe_total_weighted; // batted ball events
            public double barrel_runs_scale;
            public double barrel; // barrel scaled to runs value
            public double w2021 = 0.7;
            public double gp_2021;
            public double pa_2021;
            private double bip_2021;
            private double ba_2021;
            private double est_ba_2021;
            private double est_ba_minus_ba_diff_2021;
            private double slg_2021;
            private double est_slg_2021;
            private double est_slg_minus_slg_diff_2021;
            private double woba_2021;
            private double est_woba_2021;
            private double est_woba_minus_woba_diff_2021;
            private double bsr_2021;
            private double bsrpg_2021;
            private double def_2021;
            private double defpg_2021;
            public double bbe_2021;
            public double barrel_2021;
            public double w2020 = 0.18;
            public double gp_2020;
            public double pa_2020;
            private double bip_2020;
            private double ba_2020;
            private double est_ba_2020;
            private double est_ba_minus_ba_diff_2020;
            private double slg_2020;
            private double est_slg_2020;
            private double est_slg_minus_slg_diff_2020;
            private double woba_2020;
            private double est_woba_2020;
            private double est_woba_minus_woba_diff_2020;
            private double bsr_2020;
            private double bsrpg_2020;
            private double def_2020;
            private double defpg_2020;
            public double bbe_2020;
            public double barrel_2020;
            public double w2019 = 0.12;
            public double gp_2019;
            public double pa_2019;
            private double bip_2019;
            private double ba_2019;
            private double est_ba_2019;
            private double est_ba_minus_ba_diff_2019;
            private double slg_2019;
            private double est_slg_2019;
            private double est_slg_minus_slg_diff_2019;
            private double woba_2019;
            private double est_woba_2019;
            private double est_woba_minus_woba_diff_2019;
            private double bsr_2019;
            private double bsrpg_2019;
            private double def_2019;
            private double defpg_2019;
            public double bbe_2019;
            public double barrel_2019;

            // create the player using first name and last name
            public Batter(String a, String b, String c) {
                last_name = a.toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                        .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "");
                first_name = b.toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                        .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "");
                team_name = c.toLowerCase().strip();
                if (team_name.compareTo("sd") == 0) {
                    team_name = "sdp";
                }
                if (team_name.compareTo("sf") == 0) {
                    team_name = "sfg";
                }
                if (team_name.compareTo("kc") == 0) {
                    team_name = "kcr";
                }
                if (team_name.compareTo("was") == 0) {
                    team_name = "wsn";
                }
                if (team_name.compareTo("tb") == 0) {
                    team_name = "tbr";
                }
            }

            // set batting statistics
            public void setBarrel2021(String a, String b) {
                barrel_2021 = Double.valueOf(a);
                bbe_2021 = Double.valueOf(b);
            }

            public void setBarrel2020(String a, String b) {
                barrel_2020 = Double.valueOf(a);
                bbe_2020 = Double.valueOf(b);
            }

            public void setBarrel2019(String a, String b) {
                barrel_2019 = Double.valueOf(a);
                bbe_2019 = Double.valueOf(b);
            }

            public void setOBatter2021(String e, String f, String g, String h, String i, String j, String k, String l,
                    String m, String n, String o) {
                pa_2021 = Double.valueOf(e);
                bip_2021 = Double.valueOf(f);
                ba_2021 = Double.valueOf(g);
                est_ba_2021 = Double.valueOf(h);
                est_ba_minus_ba_diff_2021 = Double.valueOf(i);
                slg_2021 = Double.valueOf(j);
                est_slg_2021 = Double.valueOf(k);
                est_slg_minus_slg_diff_2021 = Double.valueOf(l);
                woba_2021 = Double.valueOf(m);
                est_woba_2021 = Double.valueOf(n);
                est_woba_minus_woba_diff_2021 = Double.valueOf(o);
            }

            public void setOBatter2020(String e, String f, String g, String h, String i, String j, String k, String l,
                    String m, String n, String o) {
                pa_2020 = Double.valueOf(e);
                bip_2020 = Double.valueOf(f);
                ba_2020 = Double.valueOf(g);
                est_ba_2020 = Double.valueOf(h);
                est_ba_minus_ba_diff_2020 = Double.valueOf(i);
                slg_2020 = Double.valueOf(j);
                est_slg_2020 = Double.valueOf(k);
                est_slg_minus_slg_diff_2020 = Double.valueOf(l);
                woba_2020 = Double.valueOf(m);
                est_woba_2020 = Double.valueOf(n);
                est_woba_minus_woba_diff_2020 = Double.valueOf(o);
            }

            public void setOBatter2019(String e, String f, String g, String h, String i, String j, String k, String l,
                    String m, String n, String o) {
                pa_2019 = Double.valueOf(e);
                bip_2019 = Double.valueOf(f);
                ba_2019 = Double.valueOf(g);
                est_ba_2019 = Double.valueOf(h);
                est_ba_minus_ba_diff_2019 = Double.valueOf(i);
                slg_2019 = Double.valueOf(j);
                est_slg_2019 = Double.valueOf(k);
                est_slg_minus_slg_diff_2019 = Double.valueOf(l);
                woba_2019 = Double.valueOf(m);
                est_woba_2019 = Double.valueOf(n);
                est_woba_minus_woba_diff_2019 = Double.valueOf(o);
            }

            // set baserunning/D statistics as well as GP
            public void setDBatter2021(String c, String s, String u) {
                gp_2021 = Double.valueOf(c);
                bsr_2021 = Double.valueOf(s);
                bsrpg_2021 = bsr_2021 / gp_2021;
                def_2021 = Double.valueOf(u);
                defpg_2021 = def_2021 / gp_2021;
            }

            public void setDBatter2020(String c, String s, String u) {
                gp_2020 = Double.valueOf(c);
                bsr_2020 = Double.valueOf(s);
                bsrpg_2020 = bsr_2020 / gp_2020;
                def_2020 = Double.valueOf(u);
                defpg_2020 = def_2021 / gp_2020;
            }

            public void setDBatter2019(String c, String s, String u) {
                gp_2019 = Double.valueOf(c);
                bsr_2019 = Double.valueOf(s);
                bsrpg_2019 = bsr_2019 / gp_2019;
                def_2019 = Double.valueOf(u);
                defpg_2019 = def_2019 / gp_2019;
            }

            public double getpa_total() {
                pa_total = pa_2019 + pa_2020 + pa_2021;
                return pa_total;
            }

            public double getbbe_total() {
                bbe_total = bbe_2019 + bbe_2020 + bbe_2021;
                return bbe_total;
            }

            public double getO() {
                // xwoba
                pa_total_weighted = pa_2019 * w2019 + pa_2020 * w2020 + pa_2021 * w2021;
                if (getbbe_total() < 50) {
                    xwoba = xwoba_constant * 0.85;
                    xwoba_runs_scale = (runs_average / (9 * xwoba_constant)) * xwoba; // if sample size is less than 50
                                                                                      // batted balls
                } else {
                    xwoba = (pa_2019 * w2019 * est_woba_2019 + pa_2020 * w2020 * est_woba_2020
                            + pa_2021 * w2021 * est_woba_2021) / (pa_total_weighted);
                    xwoba_runs_scale = (runs_average / (9 * xwoba_constant)) * xwoba;
                }
                // barrel
                bbe_total_weighted = bbe_2019 * w2019 + bbe_2020 * w2020 + bbe_2021 * w2021;
                if (getbbe_total() < 50) {
                    barrel = 5; // if sample size is less than 50 ABs
                    barrel_runs_scale = (runs_average / (9 * barrel_constant)) * (barrel); // if sample size is less
                                                                                           // than 50 batted balls,
                                                                                           // assuming league average is
                                                                                           // 6%
                } else {
                    barrel = (bbe_2019 * w2019 * barrel_2019 + bbe_2020 * w2020 * barrel_2020
                            + bbe_2021 * w2021 * barrel_2021) / (bbe_total_weighted);
                    barrel_runs_scale = (runs_average / (9 * barrel_constant)) * (barrel);
                }
                off = (barrel_runs_scale) * 0.5 + (xwoba_runs_scale) * 0.5; // assuming 50-50 weights
                return off;
            }

            public double getB() {
                bsr = bsrpg_2019 * w2019 + bsrpg_2020 * w2020 + bsrpg_2021 * w2021;
                return bsr;
            }

            public double getD() {
                def = defpg_2019 * w2019 + defpg_2020 * w2020 + defpg_2021 * w2021;
                return def;
            }

            public String getlast_name() {
                return last_name;
            }

            public String getfirst_name() {
                return first_name;
            }

            public void printPlayer() {
                System.out.println(first_name + " " + last_name + " xWOBA: " + xwoba);
            }

        }
        // end of batter class

        // pitcher class

        public static class Pitcher {
            public String last_name;
            public String first_name;
            public String team_name;
            public double xwoba_constant = 0.316; // .85 * league average of 0.316
            public double battedkbb_runs_constant = 9.5; // this can be tweaked
            public double runs_average = 4.52; // average
            public double pa_total;
            public double pa_total_weighted;
            public double bbe_total;
            public double bbe_total_weighted;
            public double battedkbb_runs;
            public double barrel;
            public double kk;
            public double bb;
            public double pit;
            public double xawoba;
            public double pa_2021;
            public double xawoba_2021;
            public double kk_2021;
            public double bb_2021;
            public double barrel_2021;
            public double bbe_2021;
            public double w2021 = 0.7;
            public double pa_2020;
            public double xawoba_2020;
            public double kk_2020;
            public double bb_2020;
            public double barrel_2020;
            public double bbe_2020;
            public double w2020 = 0.18;
            public double pa_2019;
            public double xawoba_2019;
            public double kk_2019;
            public double bb_2019;
            public double barrel_2019;
            public double bbe_2019;
            public double w2019 = 0.12;

            // create the player using first name and last name
            public Pitcher(String a, String b, String c) {
                last_name = a.toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                        .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "");
                first_name = b.toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                        .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "");
                team_name = c.toLowerCase().strip();
                if (team_name.compareTo("sd") == 0) {
                    team_name = "sdp";
                }
                if (team_name.compareTo("sf") == 0) {
                    team_name = "sfg";
                }
                if (team_name.compareTo("kc") == 0) {
                    team_name = "kcr";
                }
                if (team_name.compareTo("was") == 0) {
                    team_name = "wsn";
                }
                if (team_name.compareTo("tb") == 0) {
                    team_name = "tbr";
                }
            }

            public void setPitcher2021(String a, String b) {
                pa_2021 = Double.valueOf(a);
                xawoba_2021 = Double.valueOf(b);
            }

            public void setPitcher2020(String a, String b) {
                pa_2020 = Double.valueOf(a);
                xawoba_2020 = Double.valueOf(b);
            }

            public void setPitcher2019(String a, String b) {
                pa_2019 = Double.valueOf(a);
                xawoba_2019 = Double.valueOf(b);
            }

            public void setPBarrel2021(String a, String b) {
                barrel_2021 = Double.valueOf(a);
                bbe_2021 = Double.valueOf(b);
            }

            public void setPBarrel2020(String a, String b) {
                barrel_2020 = Double.valueOf(a);
                bbe_2020 = Double.valueOf(b);
            }

            public void setPBarrel2019(String a, String b) {
                barrel_2019 = Double.valueOf(a);
                bbe_2019 = Double.valueOf(b);
            }

            public void setKKBB2021(String a, String b) {
                kk_2021 = Double.valueOf(a);
                bb_2021 = Double.valueOf(b);
            }

            public void setKKBB2020(String a, String b) {
                kk_2020 = Double.valueOf(a);
                bb_2020 = Double.valueOf(b);
            }

            public void setKKBB2019(String a, String b) {
                kk_2019 = Double.valueOf(a);
                bb_2019 = Double.valueOf(b);
            }

            public double getP() {
                pa_total = pa_2019 + pa_2020 + pa_2021;
                pa_total_weighted = pa_2019 * w2019 + pa_2020 * w2020 + pa_2021 * w2021;
                bbe_total_weighted = bbe_2019 * w2019 + bbe_2020 * w2020 + bbe_2021 * w2021;
                xawoba = (pa_2019 * w2019 * xawoba_2019 + pa_2020 * w2020 * xawoba_2020 + pa_2021 * w2021 * xawoba_2021)
                        / (pa_total_weighted);
                barrel = (bbe_2019 * w2019 * barrel_2019 + bbe_2020 * w2020 * barrel_2020
                        + bbe_2021 * w2021 * barrel_2021) / (bbe_total_weighted);
                kk = (pa_2019 * w2019 * kk_2019 + pa_2020 * w2020 * kk_2020 + pa_2021 * w2021 * kk_2021)
                        / (pa_total_weighted);
                bb = (pa_2019 * w2019 * bb_2019 + pa_2020 * w2020 * bb_2020 + pa_2021 * w2021 * bb_2021)
                        / (pa_total_weighted);
                battedkbb_runs = kk - bb - barrel;
                double component_1 = (runs_average / xwoba_constant) * xawoba * (5.0 / 9.0) * 0.6;
                double component_2 = (runs_average / battedkbb_runs) * battedkbb_runs_constant * (5.0 / 9.0) * 0.4;
                if (component_2 <= 0) {
                    System.out.println("error");
                    component_2 = runs_average * (5.0 / 9.0) * 0.4;
                }
                pit = component_1 + component_2; // expected 5 innings pitched for starting pitcher
                if (pit == 0 || pa_total < 60) {
                    xawoba = xwoba_constant * 1.15; // if sample size is too small, 1.15 * average
                    pit = (runs_average / xwoba_constant) * xawoba * (5.0 / 9.0);
                }
                return pit;
            }

            public String getlast_name() {
                return last_name;
            }

            public String getfirst_name() {
                return first_name;
            }

            public void printPlayer() {
                System.out.println(first_name + " " + last_name + " xaWOBA: " + xawoba);
            }

        }
        // end of pitcher class

        // start of lineup class
        public static class Lineup {
            List<Batter> batters_lineup = new ArrayList<Batter>();
            public String team_name;
            public double off_runs; // how many runs is lineup expected to get
            public double bsr_runs; // how many bsr runs is lineup expected to get
            public double def_runs; // how many def runs is lineup expected to get
            public double[] order_weight = new double[] { 4.55, 4.65, 4.43, 4.33, 4.24, 4.13, 4.01, 3.9, 3.77 };

            public Lineup(String a) {
                team_name = a.toLowerCase().strip();
                if (team_name.compareTo("sd") == 0) {
                    team_name = "sdp";
                }
                if (team_name.compareTo("sf") == 0) {
                    team_name = "sfg";
                }
                if (team_name.compareTo("kc") == 0) {
                    team_name = "kcr";
                }
                if (team_name.compareTo("was") == 0) {
                    team_name = "wsn";
                }
                if (team_name.compareTo("tb") == 0) {
                    team_name = "tbr";
                }
            }

            public void addbatter(Batter p) {
                batters_lineup.add(p);
            }

            public double lineup_off() {
                for (int i = 0; i < 9; i++) {
                    off_runs += batters_lineup.get(i).getO() * order_weight[i] / 4.223;
                }
                return off_runs;
            }

            public double lineup_bsr() {
                for (int i = 0; i < 9; i++) {
                    if (batters_lineup.get(i).getpa_total() > 50) { // minimum 50 plate appearances to avoid small
                                                                    // sample size
                        bsr_runs += batters_lineup.get(i).getB();
                    }
                }
                return bsr_runs;
            }

            public double lineup_def() {
                for (int i = 0; i < 9; i++) {
                    if (batters_lineup.get(i).getpa_total() > 50) { // minimum 50 plate appearances to avoid small
                                                                    // sample size
                        def_runs += batters_lineup.get(i).getD();
                    }
                }
                return def_runs;
            }

        }
        // end of lineup class

        // start of bullpen class
        public static class Bullpen {
            public String team_name;
            public double SIERA;
            public double runs_scale;

            public Bullpen(String a, String b) {
                team_name = a.toLowerCase().strip();
                if (team_name.compareTo("sd") == 0) {
                    team_name = "sdp";
                }
                if (team_name.compareTo("sf") == 0) {
                    team_name = "sfg";
                }
                if (team_name.compareTo("kc") == 0) {
                    team_name = "kcr";
                }
                if (team_name.compareTo("was") == 0) {
                    team_name = "wsn";
                }
                if (team_name.compareTo("tb") == 0) {
                    team_name = "tbr";
                }
                SIERA = Double.valueOf(b);
                runs_scale = (SIERA + 0.58) * 0.44444; // rough approximation of scaling SIERA to runs
                int k = 0;
            }

            public double bullpen_runs() {
                return runs_scale;
            }
        }
        // end of bullpen class

        // start of team class
        public static class Team {
            public String team_name;
            public int home; // 0 for away, 1 for home
            public Lineup l;
            public Bullpen b;
            public Pitcher p;
            public double runs_allowed;
            public double runs_scored;

            public Team(String a) {
                team_name = a.toLowerCase().strip();
                if (team_name.compareTo("sd") == 0) {
                    team_name = "sdp";
                }
                if (team_name.compareTo("sf") == 0) {
                    team_name = "sfg";
                }
                if (team_name.compareTo("kc") == 0) {
                    team_name = "kcr";
                }
                if (team_name.compareTo("was") == 0) {
                    team_name = "wsn";
                }
                if (team_name.compareTo("tb") == 0) {
                    team_name = "tbr";
                }

            }

            public void addHome(int homeaway) {
                home = homeaway;
            }

            public void addPitcher(Pitcher pitcher) {
                p = pitcher;
            }

            public void addLineup(Lineup lineup) {
                l = lineup;
            }

            public void addBullpen(Bullpen bullpen) {
                b = bullpen;
            }

            public double defense() {
                runs_allowed = p.getP() + b.bullpen_runs() - l.lineup_def();
                return runs_allowed;
            }

            public double offense() {
                runs_scored = l.lineup_bsr() + l.lineup_off();
                return runs_scored;
            }
        }

        public static class Matchup {
            public Team home;
            public Team away;
            public double home_team_runs;
            public double runs_average = 4.52;
            public double away_team_runs;
            public double home_team_boost = 1.0177;
            public double away_team_boost = 0.982301;
            public double standarddev = 2.94; // is 3.18452901 this the right choice for standarddev? it is making the
                                              // model way too unpredictable (close to 50-50)
            public double home_wins;
            public double away_wins;
            public double home_win_prob;
            public double away_win_prob;
            public double[] order_weight = new double[] { 4.55, 4.65, 4.43, 4.33, 4.24, 4.13, 4.01, 3.9, 3.77 };

            public Matchup(Team a, Team b) { // first team that gets loaded in is going to be the away team
                a.home = 0;
                b.home = 1;
                away = a;
                home = b;
            }

            public void results() {
                home_wins = 0;
                away_wins = 0;
                home_team_runs = Math.sqrt(home.offense() * away.defense());
                away_team_runs = Math.sqrt(away.offense() * home.defense());
                home_team_runs = home_team_runs * home_team_boost;
                away_team_runs = away_team_runs * away_team_boost;
                Random rand = new Random();
                double rand_home;
                double home_score;
                double rand_away;
                double away_score;
                // now calculate win probability using 1000000 simulations
                for (int i = 0; i < 1000000; i++) {
                    rand_home = rand.nextGaussian();
                    home_score = rand_home * standarddev + home_team_runs;
                    rand_away = rand.nextGaussian();
                    away_score = rand_away * standarddev + away_team_runs;
                    if (home_score > away_score) {
                        home_wins += 1;
                    } else {
                        away_wins += 1;
                    }
                }
                home_win_prob = (home_wins * 100) / (home_wins + away_wins);
                away_win_prob = (away_wins * 100) / (away_wins + home_wins);
                home_win_prob = (double) Math.round(home_win_prob * 100) / 100;
                away_win_prob = (double) Math.round(away_win_prob * 100) / 100;
                home_team_runs = (double) Math.round(home_team_runs * 100) / 100;
                away_team_runs = (double) Math.round(away_team_runs * 100) / 100;
                System.out.println(home.team_name.toUpperCase() + ": " + home_team_runs + " with chance of winning "
                        + home_win_prob + "%");
                System.out.println(away.team_name.toUpperCase() + ": " + away_team_runs + " with chance of winning "
                        + away_win_prob + "%");

                // write the results_game_cards to the file
                try {
                    FileOutputStream fos = new FileOutputStream(
                            "/Users/jacobweissman/Downloads/_ComputerFolks/results_run_cards.csv", true);
                    String s = ",,," + home.team_name.toUpperCase() + "," + home_team_runs + ",," + +away_team_runs
                            + "," + away.team_name.toUpperCase();
                    fos.write(s.getBytes());
                    s = "\n";
                    fos.write(s.getBytes());
                    s = ",,,,,xR Against";
                    fos.write(s.getBytes());
                    s = "\n";
                    fos.write(s.getBytes());
                    double ho = (double) Math.round(home.offense() * 100) / 100; // home offense rounded
                    double hd = (double) Math.round(home.defense() * 100) / 100; // home defense rounded
                    double ao = (double) Math.round(away.offense() * 100) / 100; // away offense rounded
                    double ad = (double) Math.round(away.defense() * 100) / 100; // away defense rounded
                    s = ",,," + home.p.first_name.toUpperCase() + " " + home.p.last_name.toUpperCase() + "," + hd + ",,"
                            + ad + "," + away.p.first_name.toUpperCase() + " " + away.p.last_name.toUpperCase() + "\n";
                    fos.write(s.getBytes());
                    s = ",,,," + home.team_name.toUpperCase() + " BULLPEN + DEFENSE" + ",,"
                            + away.team_name.toUpperCase() + " BULLPEN + DEFENSE" + "\n";
                    fos.write(s.getBytes());
                    s = ",,," + home.team_name.toUpperCase() + " LINEUP" + ",,xR Added,," + away.team_name.toUpperCase()
                            + " LINEUP" + "\n";
                    fos.write(s.getBytes());

                    String homeplayername;
                    double homeplayerruns;
                    String hpruns;
                    String awayplayername;
                    String apruns;
                    double awayplayerruns;
                    // now we must add each player from each lineup as we go
                    for (int i = 0; i < 9; i++) {
                        homeplayername = home.l.batters_lineup.get(i).first_name.toUpperCase() + " "
                                + home.l.batters_lineup.get(i).last_name.toUpperCase();
                        homeplayerruns = (double) Math
                                .round(home.l.batters_lineup.get(i).off * order_weight[i] / 4.223 * 100) / 100;
                        hpruns = Double.toString(homeplayerruns);
                        awayplayername = away.l.batters_lineup.get(i).first_name.toUpperCase() + " "
                                + away.l.batters_lineup.get(i).last_name.toUpperCase();
                        awayplayerruns = (double) Math
                                .round(away.l.batters_lineup.get(i).off * order_weight[i] / 4.223 * 100) / 100;
                        apruns = Double.toString(awayplayerruns);
                        s = ",,," + homeplayername + "," + hpruns + ",," + apruns + "," + awayplayername + "\n";
                        fos.write(s.getBytes());
                    }
                    s = "\n" + "\n" + "\n";
                    fos.write(s.getBytes());
                    fos.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                // write the results_betting_odds to the file
                try {
                    FileOutputStream bos = new FileOutputStream(
                            "/Users/jacobweissman/Downloads/_ComputerFolks/results_betting_odds.csv", true);
                    String bs = home.team_name.toUpperCase() + "," + home.p.first_name.toUpperCase() + " "
                            + home.p.last_name.toUpperCase() + "," + home_win_prob + "%" + "," + home_team_runs;
                    bos.write(bs.getBytes());
                    bs = "\n";
                    bos.write(bs.getBytes());
                    bs = away.team_name.toUpperCase() + "," + away.p.first_name.toUpperCase() + " "
                            + away.p.last_name.toUpperCase() + "," + away_win_prob + "%" + "," + away_team_runs;
                    bos.write(bs.getBytes());
                    bs = "\n" + "\n";
                    bos.write(bs.getBytes());
                    bos.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

                System.out.println("");
                System.out.println("");
                System.out.println("");
                // finish writing to file and printing scores
            }
        }

        public static void main(String[] args) {
            String line = "";
            List<Batter> batters = new ArrayList<Batter>();
            List<Pitcher> pitchers = new ArrayList<Pitcher>();
            List<Bullpen> bullpens = new ArrayList<Bullpen>();
            List<Lineup> lineups = new ArrayList<Lineup>();
            List<Team> teams = new ArrayList<Team>();
            List<Matchup> matchups = new ArrayList<Matchup>();

            // load the batters/pitchers that are playing today into the model
            String path = "/Users/jacobweissman/Downloads/_ComputerFolks/Lineups_2022_04_15.csv";
            int nine_count = 0; // this variable will keep track of when to skip to the next lineup
            int lineup_num = -1; // this variable will keep track of what lineup the program is up to as it adds
                                 // lineups
            int team_num = -1; // not used
            int batter_num = 0; // this variable will keep track of what batter the program is up to as it adds
                                // batters to the lineups
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    if (value[6].compareTo("SP") == 0) {
                        pitchers.add(new Pitcher(value[5], value[4], value[0]));
                    } else {
                        // handle discrepencies between websites
                        if (value[4].toLowerCase().compareTo("peter") == 0
                                && value[5].toLowerCase().toLowerCase().compareTo("alonso") == 0) {
                            value[4] = "pete";
                        }
                        if (value[4].toLowerCase().compareTo("shohei") == 0
                                && value[5].toLowerCase().compareTo("(h)") == 0) {
                            value[5] = "ohtani";
                        }
                        if (value[4].toLowerCase().compareTo("yulieski") == 0
                                && value[5].toLowerCase().compareTo("gurriel") == 0) {
                            value[4] = "yuli";
                        }
                        if (value[4].toLowerCase().compareTo("michael") == 0
                                && value[5].toLowerCase().compareTo("taylor") == 0) {
                            value[4] = "michael a.";
                        }
                        if (value[4].toLowerCase().compareTo("JT") == 0
                                && value[5].toLowerCase().compareTo("realmuto") == 0) {
                            value[4] = "j.t.";
                        }
                        if (value[4].toLowerCase().compareTo("patrick") == 0
                                && value[5].toLowerCase().compareTo("valaika") == 0) {
                            value[4] = "pat";
                        }
                        if (value[4].toLowerCase().compareTo("giovanny") == 0
                                && value[5].toLowerCase().compareTo("urshela") == 0) {
                            value[4] = "gio";
                        }
                        if (value[4].toLowerCase().compareTo("joseph") == 0
                                && value[5].toLowerCase().compareTo("wendle") == 0) {
                            value[4] = "joey";
                        }
                        if (value[4].toLowerCase().compareTo("hyun-jin") == 0
                                && value[5].toLowerCase().compareTo("ryu") == 0) {
                            value[4] = "hyun jin";
                        }
                        if (value[4].toLowerCase().compareTo("nathaniel") == 0
                                && value[5].toLowerCase().compareTo("lowe") == 0) {
                            value[4] = "nate";
                        }

                        batters.add(new Batter(value[5], value[4], value[0])); // create the batter
                        if (nine_count % 9 == 0) { // test to see if a new lineup/team should be created
                            lineups.add(new Lineup(value[0])); // create a new lineup for the team if the program is up
                                                               // to the first batter
                            teams.add(new Team(value[0])); // create a new team if the program is up to the first batter
                                                           // of the team
                            lineup_num++; // increase the variable keeping track of the number of lineups
                            team_num++;
                        }
                        lineups.get(lineup_num).addbatter(batters.get(batter_num)); // add the battter to the lineup
                        batter_num++; // increase batter index
                        nine_count++;
                    }
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // load and set offense batter statistics 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/batters_2021.csv"; // UPDATE baseball savant, remove
                                                                                     // top line
                                                                                     // https://baseballsavant.mlb.com/leaderboard/expected_statistics?type=batter&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace(" jr.", "");
                        if (value[0].toLowerCase().strip().replace("jr.", "").compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setOBatter2021(value[4], value[5], value[6], value[7], value[8], value[9],
                                    value[10], value[11], value[12], value[13], value[14]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set offense batter statistics 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/batters_2020.csv"; // baseball savant, remove top line
                                                                                     // https://baseballsavant.mlb.com/leaderboard/expected_statistics?type=batter&year=2020&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace("jr.", "");
                        if (value[0].toLowerCase().strip().replace("jr.", "").compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setOBatter2020(value[4], value[5], value[6], value[7], value[8], value[9],
                                    value[10], value[11], value[12], value[13], value[14]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set offense batter statistics 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/batters_2019.csv"; // baseball savant, remove top line
                                                                                     // https://baseballsavant.mlb.com/leaderboard/expected_statistics?type=batter&year=2019&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace("jr.", "");
                        if (value[0].toLowerCase().strip().replace("jr.", "").compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setOBatter2019(value[4], value[5], value[6], value[7], value[8], value[9],
                                    value[10], value[11], value[12], value[13], value[14]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set barrel batter statistics 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/exit_2019.csv"; // baseball savant, remove top line
                                                                                  // https://baseballsavant.mlb.com/leaderboard/statcast?type=batter&year=2019&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace("jr.", "");
                        if (value[0].toLowerCase().strip().compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setBarrel2019(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set barrel batter statistics 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/exit_2020.csv"; // baseball savant, remove top line
                                                                                  // https://baseballsavant.mlb.com/leaderboard/statcast?type=batter&year=2020&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace("jr.", "");
                        if (value[0].toLowerCase().strip().compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setBarrel2020(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set barrel batter statistics 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/exit_2021.csv"; // baseball savant, remove top line
                                                                                  // https://baseballsavant.mlb.com/leaderboard/statcast?type=batter&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        value[0] = value[0].toLowerCase().strip().replace("jr.", "");
                        if (value[0].toLowerCase().strip().compareTo(batters.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(batters.get(i).first_name) == 0) {
                            batters.get(i).setBarrel2021(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set batter defense/bsr 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/fgd_2021.csv"; // UPDATE fangraphs baserunning
                                                                                 // defense, remove " and top line,
                                                                                 // https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=20&type=8&season=2021&month=0&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        name = batters.get(i).first_name + " " + batters.get(i).last_name;
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .compareTo(name) == 0) {
                            batters.get(i).setDBatter2021(value[2], value[18], value[20]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set batter defense/bsr 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/fgd_2020.csv"; // fangraphs baserunning defense,
                                                                                 // remove " and top line
                                                                                 // https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=20&type=8&season=2020&month=1000&season1=2020&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2020-01-01&enddate=2020-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        name = batters.get(i).first_name + " " + batters.get(i).last_name;
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .compareTo(name) == 0) {
                            batters.get(i).setDBatter2020(value[2], value[18], value[20]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set batter defense/bsr 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/fgd_2019.csv"; // fangraphs baserunning defense,
                                                                                 // remove " and top line
                                                                                 // https://www.fangraphs.com/leaders.aspx?pos=all&stats=bat&lg=all&qual=20&type=8&season=2019&month=1000&season1=2019&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2019-01-01&enddate=2019-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < batters.size(); i++) {
                        name = batters.get(i).first_name + " " + batters.get(i).last_name;
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .compareTo(name) == 0) {
                            batters.get(i).setDBatter2019(value[2], value[18], value[20]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pitchers_2021.csv"; // UPDATE baseball savant, remove
                                                                                      // top line
                                                                                      // https://baseballsavant.mlb.com/leaderboard/expected_statistics?type=pitcher&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPitcher2021(value[4], value[13]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pitchers_2020.csv"; // baseball savant, remove top
                                                                                      // line
                                                                                      // https://baseballsavant.mlb.com/leaderboard/expected_statistics?type=pitcher&year=2020&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPitcher2020(value[4], value[13]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pitchers_2019.csv"; // baseball savant, remove top
                                                                                      // line
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPitcher2019(value[4], value[13]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics barrel 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pb_2021.csv"; // baseball savant, remove top line
                                                                                // https://baseballsavant.mlb.com/leaderboard/statcast?type=pitcher&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPBarrel2021(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics barrel 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pb_2020.csv"; // baseball savant, remove top line
                                                                                // https://baseballsavant.mlb.com/leaderboard/statcast?type=pitcher&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPBarrel2020(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics barrel 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/pb_2019.csv"; // baseball savant, remove top line
                                                                                // https://baseballsavant.mlb.com/leaderboard/statcast?type=pitcher&year=2021&position=&team=&min=25
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        if (value[0].toLowerCase().strip().compareTo(pitchers.get(i).last_name) == 0
                                && value[1].toLowerCase().strip().compareTo(pitchers.get(i).first_name) == 0) {
                            pitchers.get(i).setPBarrel2019(value[18], value[3]);
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics kk/bb 2021
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/kkbb_2021.csv"; // UPDATE fangraphs, remove "" and top
                                                                                  // line
                                                                                  // https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=1&season=2021&month=16&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        name = pitchers.get(i).first_name + " " + pitchers.get(i).last_name;
                        name.replace("hyun-jin", "hyun jin");
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .replace("hyun-jin", "hyun jin").compareTo(name) == 0) {
                            pitchers.get(i).setKKBB2021(value[6].replace("%", ""), value[7].replace("%", ""));
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics kk/bb 2020
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/kkbb_2020.csv"; // fangraphs, remove "" and top line
                                                                                  // https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=1&season=2021&month=16&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        name = pitchers.get(i).first_name + " " + pitchers.get(i).last_name;
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .replace("hyun-jin", "hyun jin").compareTo(name) == 0) {
                            pitchers.get(i).setKKBB2020(value[6].replace("%", ""), value[7].replace("%", ""));
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // load and set pitcher statistics kk/bb 2019
            path = "/Users/jacobweissman/Downloads/_ComputerFolks/kkbb_2019.csv"; // fangraphs, remove "" and top line
                                                                                  // https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=10&type=1&season=2021&month=16&season1=2021&ind=0&team=0&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31
            try {
                String name;
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    for (int i = 0; i < pitchers.size(); i++) {
                        name = pitchers.get(i).first_name + " " + pitchers.get(i).last_name;
                        if (value[0].toLowerCase().strip().replace("í", "i").replace("á", "a").replace("é", "e")
                                .replace("ñ", "n").replace("ó", "o").replace("ú", "u").replace(" jr.", "")
                                .replace("hyun-jin", "hyun jin").compareTo(name) == 0) {
                            pitchers.get(i).setKKBB2019(value[6].replace("%", ""), value[7].replace("%", ""));
                        }
                    }
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            path = "/Users/jacobweissman/Downloads/_ComputerFolks/bullpens.csv"; // note: for the start of the season
                                                                                 // include 2021 data as well in the
                                                                                 // date range
            // UPDATE fangraphs, remove "" and top line
            // https://www.fangraphs.com/leaders.aspx?pos=all&stats=rel&lg=all&qual=0&type=1&season=2021&month=0&season1=2021&ind=0&team=0,ts&rost=0&age=0&filter=&players=0&startdate=2021-01-01&enddate=2021-12-31
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] value = line.split(",");
                    bullpens.add(new Bullpen(value[0], value[19]));
                    // System.out.println(line);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // create the file which will collect the results_run_cards
            try {
                File myObj = new File("/Users/jacobweissman/Downloads/_ComputerFolks/results_run_cards.csv");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // create the file which will collect the results_betting_odds
            try {
                File myObj = new File("/Users/jacobweissman/Downloads/_ComputerFolks/results_betting_odds.csv");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // create teams, each of which has a lineup, a pitcher, and a bullpen
            // add the lineup
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < lineups.size(); j++) { // add the lineup
                    if (teams.get(i).team_name.strip().compareTo(lineups.get(j).team_name) == 0) { // if the team
                                                                                                   // team_name and the
                                                                                                   // lineup team_name
                                                                                                   // are the same
                        teams.get(i).addLineup(lineups.get(j));
                    }
                }
            }
            // add the pitcher
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < pitchers.size(); j++) { // add the pitcher
                    if (teams.get(i).team_name.strip().compareTo(pitchers.get(j).team_name) == 0) { // if the team
                                                                                                    // team_name and the
                                                                                                    // pitcher team_name
                                                                                                    // are the same
                        teams.get(i).addPitcher(pitchers.get(j));
                    }
                }
            }
            // add the bullpen
            for (int i = 0; i < teams.size(); i++) {
                for (int j = 0; j < bullpens.size(); j++) { // add the bullpen
                    if (teams.get(i).team_name.compareTo(bullpens.get(j).team_name) == 0) { // if the team team_name and
                                                                                            // the bullpen team_name are
                                                                                            // the same
                        teams.get(i).addBullpen(bullpens.get(j));
                    }
                }
            }

            // load teams into matchups
            for (int i = 0, j = 0; i < teams.size(); i++, j++) {
                matchups.add(new Matchup(teams.get(i), teams.get(i + 1)));
                System.out.println("Game #" + (j + 1) + " predicted score: ");
                matchups.get(j).results();
                i++;
            }
            int j = 2;

        }
    }
}

/*
 * get the win prob onto the player card once Seth updates the spot
 * create a blog website to upload the picks every day
 * 
 * B: xwoba and barrel% average (tweak the weights?)
 * P: xawoba and barrel% + BB% - K% average (tweak the weights?)
 * tinker with and figure out the right player average constants
 * 
 * 4.602257 runs for home team, 4.43641 runs for away team
 * 4.52 runs per game is average
 * https://baseballsavant.mlb.com/leaderboard/statcast?type=pitcher&year=2021&
 * position=&team=&min=25
 * https://technology.mlblogs.com/an-introduction-to-expected-weighted-on-base-
 * average-xwoba-29d6070ba52b
 * https://baseballsavant.mlb.com/leaderboard/expected_statistics
 * https://www.fangraphs.com/leaders.aspx?pos=all&stats=pit&lg=all&qual=y&type=1
 * &season=2021&month=16&season1=2021&ind=0
 * run data used to calculate variance
 * https://stathead.com/baseball/inning_summary.cgi?request=1&year_id=2021
 * standard dev: 3.18452901
 * var: 10.1412250
 * predicted run totals based on average MLB stadium. Therefore, the predicted
 * run totals cannot accurately be used to bet over/under
 * 
 * note: DH defense is included, not sure how to avoid that in a simple fashion
 * 
 * 
 */
