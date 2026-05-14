import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * インタラクティブ・ライフゲーム
 * 操作方法:
 * - マウス左クリック: セルの生存/死滅を切り替え
 * - スペースキー: 自動演化の開始/停止
 * - エンターキー: 1世代だけ進める（ステップ実行）
 * - Cキー: 画面をクリア
 */
public class InteractiveLifeGame extends JFrame {
    public InteractiveLifeGame() {
        GamePanel panel = new GamePanel();
        add(panel);
        
        // ウィンドウ設定
        setTitle("ライフゲーム (操作: Space=開始/停止, Enter=次へ, C=クリア)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Swingの推奨される実行方法
        SwingUtilities.invokeLater(() -> new InteractiveLifeGame());
    }
}

class GamePanel extends JPanel implements ActionListener {
    private final int CELL_SIZE = 20; // セルのサイズ
    private final int ROWS = 30;     // 行数
    private final int COLS = 30;     // 列数
    private int[][] board = new int[ROWS][COLS];
    private Timer timer;
    private boolean isRunning = false;

    public GamePanel() {
        // パネルのサイズ設定
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.BLACK);
        
        // 100ミリ秒ごとにactionPerformedを呼び出す
        timer = new Timer(100, this);

        // キーボード入力を有効にする
        setFocusable(true);

        // マウス操作: セルの状態を反転させる
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / CELL_SIZE;
                int row = e.getY() / CELL_SIZE;
                
                if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                    board[row][col] = (board[row][col] == 1) ? 0 : 1;
                    repaint(); // 再描画
                }
            }
        });

        // キー操作の設定
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE: // スペースキーで開始/停止
                        isRunning = !isRunning;
                        if (isRunning) timer.start();
                        else timer.stop();
                        break;
                        
                    case KeyEvent.VK_ENTER: // エンターキーで1ステップ進む
                        updateBoard();
                        repaint();
                        break;
                        
                    case KeyEvent.VK_C: // Cキーで全消去
                        board = new int[ROWS][COLS];
                        isRunning = false;
                        timer.stop();
                        repaint();
                        break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // グリッド線（補助線）の描画
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i <= ROWS; i++) g.drawLine(0, i * CELL_SIZE, getWidth(), i * CELL_SIZE);
        for (int i = 0; i <= COLS; i++) g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, getHeight());

        // 生きているセルの描画
        g.setColor(Color.CYAN);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 1) {
                    // 少し小さく描画してグリッドを見やすくする
                    g.fillRect(c * CELL_SIZE + 1, r * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateBoard();
        repaint();
    }

    /**
     * 次の世代の盤面を計算するロジック
     */
    private void updateBoard() {
        int[][] nextBoard = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int neighbors = countNeighbors(r, c);
                
                if (board[r][c] == 1) {
                    // 生存ルール: 隣接する生きたセルが2か3なら生存
                    nextBoard[r][c] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    // 誕生ルール: 隣接する生きたセルがちょうど3なら誕生
                    nextBoard[r][c] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        board = nextBoard;
    }

    /**
     * 指定されたセルの周囲8マスの生きたセルを数える
     */
    private int countNeighbors(int r, int c) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // 自分自身は除外
                
                // トーラス状（端と端がつながっている）の処理
                int row = (r + i + ROWS) % ROWS;
                int col = (c + j + COLS) % COLS;
                count += board[row][col];
            }
        }
        return count;
    }
}