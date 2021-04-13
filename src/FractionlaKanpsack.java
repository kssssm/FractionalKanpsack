
import java.util.*;

public class FractionlaKanpsack {




        private static double[] getValue(int capacity, int[] value, int[] weight, int n) {
            double totalValue = 0;
            double totalWeight = 0;
            int i=0;

            double[] itemList=new double[n+1];
            while (totalWeight <= capacity) {
                int maxidx = getMaxidx(value, weight);

                if (totalWeight + weight[maxidx] <= capacity) {
                    totalWeight += weight[maxidx];
                    totalValue += value[maxidx];
                }
                else {
                    double diff = capacity - totalWeight;

                    totalWeight += diff;
                    totalValue += diff * ((double) value[maxidx]/(double)weight[maxidx]);
                }
                itemList[i+1]=maxidx+1;
                value[maxidx] = 0;
                i++;
                if (totalWeight == capacity) {
                    itemList[0]=totalValue;
                    break;
                }
            }
            return itemList;
        }


        private static int getMaxidx(int[] value, int[] weight) {
            double curVal = 0;
            double maxVal = 0;
            int maxidx = 0;

            for (int i=0; i < value.length; ++i) {
                curVal = (double) value[i]/(double)weight[i];
                if (curVal > maxVal) {
                    maxVal = curVal;
                    maxidx = i;
                }
            }
            return maxidx;
        }

        public static void main(String args[]) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int C = scanner.nextInt();
            int[] value = new int[n];
            int[] weight = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = scanner.nextInt();
                weight[i] = scanner.nextInt();
            }
            double[] itemList=getValue(C, value, weight, n);
            System.out.println("총 가치의 합은 " + itemList[0]);
            for (int j=1; j<=n; j++){

                System.out.println((int) itemList[j] + "번 아이템");
            }

        }
    }