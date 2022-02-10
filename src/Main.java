import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                int month = 0;
                int day = 0;
                int steps = 0;
                while (true) {
                    System.out.println("Выберите месяц:");
                    listOfMonth();
                    int numOfMonth = scanner.nextInt();
                    if ((numOfMonth > 0) && (numOfMonth < 13)) {
                        month = numOfMonth;
                        break;
                    } else System.out.println("Ошибка ввода. Выберите номер месяца от 1 до 12");
                }
                while (true) {
                    System.out.println("Введите число месяца");
                    int dayOfMonth = scanner.nextInt();
                    if ((dayOfMonth > 0) && (dayOfMonth < 31)) {
                        day = dayOfMonth;
                        break;
                    } else System.out.println("Ошибка ввода. Введите число от 1 до 30");
                }
                while (true) {
                    System.out.println("Введите кол-во шагов за число");
                    int stepsPerDay = scanner.nextInt();
                    if ((stepsPerDay > 0)) {
                        steps = stepsPerDay;
                        stepTracker.inputStepsCount(month, day, steps);
                        System.out.println("Данные записаны");
                        break;
                    } else System.out.println("Ошибка ввода. Введите число больше нуля");
                }
            } else if (userInput == 2) {
                while (true) {
                    System.out.println("Укажите месяц, за который хотите получить статистику:");
                    listOfMonth();
                    int numOfMonth = scanner.nextInt();
                    if((numOfMonth > 0) && (numOfMonth < 13)) {
                        System.out.println("Кол-во пройденных шагов по дням:");
                        for (int i = 1; i < 30; i++) {
                            System.out.print(i + " день: " + stepTracker.showStepsPerEachDay(numOfMonth).stepsPerMonth[i - 1] + ", ");
                        }
                        System.out.println(30 + " день: " + stepTracker.showStepsPerEachDay(numOfMonth).stepsPerMonth[29]);
                        System.out.println("Общее кол-во щагов за месяц: " + stepTracker.getSumOfSteps(numOfMonth) + " шагов");
                        System.out.println("Максимальное кол-во шагов в месяце: " + stepTracker.getMaxSteps(numOfMonth) + " шагов");
                        System.out.println("Среднее кол-во шагов за месяц: " + stepTracker.getAvarageSteps(numOfMonth) + " шагов в день");
                        System.out.println("Пройденная дистанция: " + stepTracker.getDistance(stepTracker.getSumOfSteps(numOfMonth)) + " км");
                        System.out.println("Кол-во соженных килокалорий: " + stepTracker.getKkal(stepTracker.getSumOfSteps(numOfMonth)) + " ккал");
                        System.out.println("Лучшая серия дней подряд: " + stepTracker.bestSeries(numOfMonth));
                        //stepTracker.showMonthStatistic(numOfMonth);
                        break;
                    } else System.out.println("Ошибка ввода. Введите номер месяца от 1 до 12");
                    // System.out.println("Общее кол-во шагов за месяц: "+ stepTracker.sumStepsForMonth(numOfMonth) + " шагов");
                    // System.out.println("Максимальное кол-во шагов в месяце: " + stepTracker.maxStepsForMonth(numOfMonth) + " шагов");
                }
            } else if (userInput == 3) {
                while (true) {
                    System.out.println("Укажите новую цель (кол-во шагов за день): ");
                    int targetSteps = scanner.nextInt();
                    if(targetSteps > 0) {
                        stepTracker.changeTarget(targetSteps);
                        System.out.println("Новая цель записана: " + targetSteps + " шагов за день");
                        break;
                    } else System.out.println("Ошибка ввода. Введите кол-во шагов больше нуля");
                }
            }

             if (userInput < 0 || userInput > 3) {
             System.out.println("Ошибка ввода. Выберите действие от 0 до 3");
             }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
            System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Внесение кол-во шагов за день");
        System.out.println("2 - Печать статистики за месяц");
        System.out.println("3 - Изменение цели (кол-во шагов в день)");
        System.out.println("0 - Выход");
    }

    public static void listOfMonth() {
        System.out.println("1 - Январь");
        System.out.println("2 - Февраль");
        System.out.println("3 - Март");
        System.out.println("4 - Апрель");
        System.out.println("5 - Май");
        System.out.println("6 - Июнь");
        System.out.println("7 - Июль");
        System.out.println("8 - Август");
        System.out.println("9 - Сентябрь");
        System.out.println("10 - Октябрь");
        System.out.println("11 - Ноябрь");
        System.out.println("12 - Декабрь");
    }
}


