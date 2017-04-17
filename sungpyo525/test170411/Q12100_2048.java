package com.test170411;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ#12100 2048 (Easy)
 * https://www.acmicpc.net/problem/12100
 * <p>
 * �ι�° Ǯ�� 17.04.09
 */

public class Q12100_2048 {

    // direction
    static final int LEFT = 0;
    static final int UP = 1;
    static final int RIGHT = 2;
    static final int DOWN = 3;

    // game info
    static int N;
    static final int LIMIT = 5;
    static int maxValue = 0;

    // map info
    static final int BLANK = 0;

    public static void main(String[] args) throws IOException {

        // input
        int[][] map = new int[21][21];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solve
        dfs(map, 0);
        System.out.println(maxValue);
    }

    static void dfs(int[][] map, int step) {

        // ����
        if (step == LIMIT) {

            updateMaxValue(map);
            return;
        }

        // Ž��
        for (int i = 0; i < 4; i++) {

            int[][] mapCopy = new int[N][N];
            for (int j = 0; j < N; j++) {

                mapCopy[j] = Arrays.copyOf(map[j], N);
            }

            dfs(action(mapCopy, i), step + 1);
        }
    }

    static int[][] action(int[][] mapCopy, int dir) {

        switch (dir) {

            case LEFT:

                for (int row = 0; row < N; row++) {

                    int nBlank = 0;
                    // ���ʿ��� ����������
                    for (int col = 1; col < N; col++) {

                        // �˻� ��� == 0
                        if (mapCopy[row][col] == BLANK) {

                            nBlank++;
                            continue;
                        } else {

                            // ���� ���� : �˻� ��� = ��� ���
                            if (mapCopy[row][col] == mapCopy[row][col - 1 - nBlank]) {

                                mapCopy[row][col - 1 - nBlank] *= 2;
                                mapCopy[row][col] = BLANK;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else if (mapCopy[row][col - 1 - nBlank] == 0) {

                                mapCopy[row][col - 1 - nBlank] = mapCopy[row][col];
                                mapCopy[row][col] = BLANK;
                                nBlank++;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� != 0 && �˻��� != �����
                            else {

                                mapCopy[row][col - nBlank] = mapCopy[row][col];
                                if (nBlank != 0) mapCopy[row][col] = BLANK;
                            }
                        }
                    }
                }

                break;

            case UP:

                for (int col = 0; col < N; col++) {

                    int nBlank = 0;
                    // ���ʿ��� �Ʒ�������
                    for (int row = 1; row < N; row++) {

                        // �˻� ��� == 0
                        if (mapCopy[row][col] == BLANK) {

                            nBlank++;
                            continue;
                        } else {

                            // ���� ���� : �˻� ��� = ��� ���
                            if (mapCopy[row - 1 - nBlank][col] == mapCopy[row][col]) {

                                mapCopy[row - 1 - nBlank][col] *= 2;
                                mapCopy[row][col] = BLANK;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else if (mapCopy[row - 1 - nBlank][col] == 0) {

                                mapCopy[row - 1 - nBlank][col] = mapCopy[row][col];
                                mapCopy[row][col] = BLANK;
                                nBlank++;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else {

                                mapCopy[row - nBlank][col] = mapCopy[row][col];
                                if (nBlank != 0) mapCopy[row][col] = BLANK;
                            }
                        }
                    }
                }
                break;

            case RIGHT:

                for (int row = 0; row < N; row++) {

                    int nBlank = 0;
                    // �����ʿ��� ��������
                    for (int col = N - 2; col >= 0; col--) {

                        // �˻� ��� == 0
                        if (mapCopy[row][col] == BLANK) {

                            nBlank++;
                            continue;
                        } else {

                            // ���� ���� : �˻� ��� = ��� ���
                            if (mapCopy[row][col] == mapCopy[row][col + 1 + nBlank]) {

                                mapCopy[row][col + 1 + nBlank] *= 2;
                                mapCopy[row][col] = BLANK;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else if (mapCopy[row][col + 1 + nBlank] == 0) {

                                mapCopy[row][col + 1 + nBlank] = mapCopy[row][col];
                                mapCopy[row][col] = BLANK;
                                nBlank++;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else {

                                mapCopy[row][col + nBlank] = mapCopy[row][col];
                                if (nBlank != 0) mapCopy[row][col] = BLANK;
                            }
                        }
                    }
                }
                break;

            case DOWN:

                for (int col = 0; col < N; col++) {

                    int nBlank = 0;
                    // �Ʒ��ʿ��� ��������
                    for (int row = N - 2; row >= 0; row--) {

                        // �˻� ��� == 0
                        if (mapCopy[row][col] == BLANK) {

                            nBlank++;
                            continue;
                        } else {

                            // ���� ���� : �˻� ��� = ��� ���
                            if (mapCopy[row + 1 + nBlank][col] == mapCopy[row][col]) {

                                mapCopy[row + 1 + nBlank][col] *= 2;
                                mapCopy[row][col] = BLANK;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else if (mapCopy[row + 1 + nBlank][col] == 0) {

                                mapCopy[row + 1 + nBlank][col] = mapCopy[row][col];
                                mapCopy[row][col] = BLANK;
                                nBlank++;
                            }
                            // ���� �Ұ��� : �˻� ��� != 0 && ��� ��� == 0
                            else {

                                mapCopy[row + nBlank][col] = mapCopy[row][col];
                                if (nBlank != 0) mapCopy[row][col] = BLANK;
                            }
                        }
                    }
                }
                break;
        }

        return mapCopy;
    }

    static void updateMaxValue(int[][] mapCopy) {

        int tempMaxValue = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                tempMaxValue = tempMaxValue < mapCopy[i][j] ? mapCopy[i][j] : tempMaxValue;
            }
        }

        maxValue = maxValue < tempMaxValue ? tempMaxValue : maxValue;
    }
}