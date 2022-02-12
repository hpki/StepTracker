import java.sql.SQLOutput;
import java.util.HashMap;

public class StepTracker {
    private HashMap<Integer, MonthData> monthToData = new HashMap<>();
    private int target = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    private static class MonthData {
        private int[] stepsPerMonth = new int[30];


        void addStepsPerDay(int day, int steps) {
            stepsPerMonth[(day)] = steps;
        }
    }

    private static class Converter {
        int steps;

        Converter(int steps) {
            this.steps = steps;
        }

        double getDistance() {
            double distInCm = steps * 75;
            double distInKm = distInCm / 100_000;
            return distInKm;
        }

        double getKkal() {
            int energyInKal = steps * 50;
            int energyInKkal = energyInKal / 1000;
            return energyInKkal;
        }
    }

    void inputStepsCount(int numOfMonth, int dayOfMonth, int stepsPerDay) {
        MonthData steps = monthToData.get(numOfMonth - 1);
        steps.addStepsPerDay((dayOfMonth - 1), stepsPerDay);
    }

    MonthData showStepsPerEachDay(int numOfMonth) {
        //System.out.println("Кол-во пройденных шагов по дням: ");
        MonthData steps = monthToData.get(numOfMonth - 1);
        return steps;
    }

    int stepsInDay(int numOfMonth, int day) {
        return showStepsPerEachDay(numOfMonth).stepsPerMonth[day - 1];
    }

    int getSumOfSteps(int numOfMonth) {
        int sum = 0;
        for (int i = 1; i < 30; i++) {
            sum = sum + showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1];
            // steps.stepsPerMonth[i - 1];
        }
        return sum;
    }

    int getMaxSteps(int numOfMonth) {
        int max = 0;
        for (int i = 1; i < 30; i++) {
            if (showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1] > max) {
                max = showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1];
            }
        }
        return max;
    }

    double getAvarageSteps(int numOfMonth) {
        int sum = 0;
        for (int i = 1; i < 30; i++) {
            sum = sum + showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1];
        }
        double avarageSteps = sum / 30.0;
        return avarageSteps;
    }

    double getDistance(int sum) {
        Converter converter = new Converter(sum);
        double distance = converter.getDistance();
        return distance;
    }

    double getKkal(int sum) {
        Converter converter = new Converter(sum);
        double kKal = converter.getKkal();
        return kKal;
    }

    int bestSeries(int numOfMonth) {
        int counter = 0;
        int maxCounter = 0;
        int bestSeries = 0;
        for (int i = 1; i < 30; i++) {
            if (showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1] >= target) {
                counter = counter + 1;
                maxCounter = counter;
            } else counter = 0;
            if (maxCounter > bestSeries) {
                bestSeries = maxCounter;
            }
        }
        return bestSeries;
    }

    /*
     int counter = 0;
     int maxCounter = 0;
     int bestSeries = 0;
     for (int i = 1; i < 30; i++) {
         if (steps.stepsPerMonth[i - 1] >= target) {
             counter = counter + 1;
             maxCounter = counter;
         } else counter = 0;
         if (maxCounter > bestSeries) {
             bestSeries = maxCounter;
         }
     }

     System.out.println("Лучшая серия: " + bestSeries + " дней");
 }
     */
    void changeTarget(int wantedSteps) {
        target = wantedSteps;
    }
}



