public abstract class Main {
    /**
     * Урок 2. Исключения
     * 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
     * текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
     * в какой именно ячейке лежат неверные данные.
     * 3. В методе main() вызвать полученный метод, обработать возможные исключения
     * MyArraySizeException и MyArrayDataException
     * и вывести результат расчета.
     */

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = new String[][]{{"1", "о", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        int sum = 0;
        for(int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (Exception e) {
                }
            }
        }

        System.out.println(sum);
        getSumOfIntsInArrayOfStrings(myArray);
    }

    public static class MyArraySizeException extends Throwable {

    }

    public static class MyArrayDataException extends Throwable {
    }


    public static void getSumOfIntsInArrayOfStrings(String[][] myArray) throws MyArraySizeException, MyArrayDataException {

        int result = 0;

        if (myArray.length != 4 || myArray[0].length != 4){;
            throw new MyArraySizeException();
           }

        for(int i = 0; i < myArray.length; i++){
            for (int j = 0; j < myArray[0].length; j++) {

                try {
                    result += Integer.parseInt(myArray[i][j]);

                } catch (Exception e){
                    System.out.println("В [" + i + " , " + j + "]" + " лежит не число, а " + myArray[i][j] + ".");
                    throw new MyArrayDataException();
                }
            }
        }
    }
}


