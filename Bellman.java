import java.util.*; 

public class BellmanFord { 

private int D[]; 

 public static final int max_value = 999; 

 public BellmanFord(int n) { 

 D = new int[n + 1]; 

 } 

 public void shortest(int s, int a[][]) { 

 int n = a.length - 1; 

for (int i = 1; i <= n; i++) { 

 D[i] = max_value; 

 } 

 D[s] = 0; 

for (int k = 1; k <= n - 1; k++) { 

for (int i = 1; i <= n; i++) { 

for (int j = 1; j <= n; j++) { 

if (a[i][j] != max_value) { 

if (D[j] > D[i] + a[i][j]) { 

 D[j] = D[i] + a[i][j]; 

 } 

 } 

 } 

 } 

 } 

 for (int i = 1; i <= n; i++) { 

for (int j = 1; j <= n; j++) {
  if (a[i][j] != max_value) { 

if (D[j] > D[i] + a[i][j]) { 

 System.out.println("The graph contains a negative edge cycle."); 

return;

 } 

 } 

 } 

 } 

 for (int i = 1; i <= n; i++) { 

 System.out.println("Distance from source " + s + " to " + i + " is " + D[i]); 

 } 

 } 

 public static void main(String[] args) { 

Scanner sc = new Scanner(System.in); 

 System.out.println("Enter the number of vertices:"); 

int n = sc.nextInt(); 

 int a[][] = new int[n + 1][n + 1]; 

 System.out.println("Enter the weighted matrix:"); 

 for (int i = 1; i <= n; i++) { 

for (int j = 1; j <= n; j++) { 

a[i][j] = sc.nextInt(); 

 if (i == j) { 

a[i][j] = 0; 

 } 

 if (a[i][j] == 0) { 

 a[i][j] = max_value; 

 } 

 } 

 } 

 System.out.println("Enter the source vertex:"); 

int s = sc.nextInt(); 

 BellmanFord b = new BellmanFord(n); 

 b.shortest(s, a); 

sc.close(); 

 } 

}
