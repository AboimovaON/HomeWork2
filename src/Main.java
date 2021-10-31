public abstract class Main {


    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] myArray = new String[][]{{"1", "n", "o", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"},{"1", "2", "3", "4"}};
        int sum = 0;
        for(int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[0].length; j++) {
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (Exception e) {
                    System.out.println();
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

        if (myArray.length != 4 || myArray[0].length != 4){
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


