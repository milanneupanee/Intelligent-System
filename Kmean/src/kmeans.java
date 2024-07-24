import java.util.Random;

public class kmeans {
    int x[], y[];
    int num = 200;  // Number of data points
    int k = 20;     // Number of clusters
    double meanX[], meanY[];
    double oldX[], oldY[];
    int cAssign[];

    public kmeans(int n, int c) {
        num = n;
        k = c;
        x = new int[num];
        y = new int[num];
        meanX = new double[k];
        meanY = new double[k];
        oldX = new double[k];
        oldY = new double[k];
        cAssign = new int[num];
    }

    void randomData() {
        Random r = new Random();
        for (int i = 0; i < num; i++) {
            x[i] = r.nextInt(1000);
            y[i] = r.nextInt(1000);
        }
    }

    void randomMean() {
        Random r = new Random();
        for (int i = 0; i < k; i++) {
            meanX[i] = r.nextInt(1000);
            meanY[i] = r.nextInt(1000);
        }
    }

    void assignCluster() {
        for (int i = 0; i < num; i++) {
            double minDistance = Double.MAX_VALUE;
            int closestCluster = -1;
            for (int j = 0; j < k; j++) {
                double distance = Math.sqrt(Math.pow(x[i] - meanX[j], 2) + Math.pow(y[i] - meanY[j], 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    closestCluster = j;
                }
            }
            cAssign[i] = closestCluster;
        }
    }

    void updateMeans() {
        int[] count = new int[k];
        double[] sumX = new double[k];
        double[] sumY = new double[k];

        for (int i = 0; i < k; i++) {
            sumX[i] = 0;
            sumY[i] = 0;
            count[i] = 0;
        }

        for (int i = 0; i < num; i++) {
            int cluster = cAssign[i];
            sumX[cluster] += x[i];
            sumY[cluster] += y[i];
            count[cluster]++;
        }

        for (int i = 0; i < k; i++) {
            if (count[i] > 0) {
                oldX[i] = meanX[i];
                oldY[i] = meanY[i];
                meanX[i] = sumX[i] / count[i];
                meanY[i] = sumY[i] / count[i];
            }
        }
    }

    boolean hasConverged() {
        for (int i = 0; i < k; i++) {
            if (oldX[i] != meanX[i] || oldY[i] != meanY[i]) {
                return false;
            }
        }
        return true;
    }

    void runKMeans() {
        randomData();
        randomMean();
        boolean converged = false;
        int iterations = 0;

        while (!converged && iterations < 100) {  // Limiting the number of iterations
            assignCluster();
            updateMeans();
            converged = hasConverged();
            iterations++;
        }

        System.out.println("K-Means converged in " + iterations + " iterations.");
        for (int i = 0; i < k; i++) {
            System.out.println("Cluster " + i + ": (" + meanX[i] + ", " + meanY[i] + ")");
        }
    }

    public static void main(String[] args) {
        kmeans kMeans = new kmeans(200, 20);
        kMeans.runKMeans();
    }
}
