import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList; // 履歴を管理するためのインポート

/**
 * インタラクティブ・ライフゲーム（巻き戻し機能付き）
 * * 【操作方法】
 * - マウス左クリック : セルの生存/死滅を切り替え
 * - スペースキー     : 自動演化（アニメーション）の開始/停止
 * - エンターキー     : 1世代だけ進める（ステップ実行）
 * - C キー          : 画面をクリア（全消去）
 * - Z キー          : 1ステップ前に巻き戻す（Undo機能）
 */
public class InteractiveLifeGame extends JFrame {
    public InteractiveLifeGame() {
        GamePanel panel = new GamePanel();
        add(panel);
        
        // ウィンドウの設定
        setTitle("ライフゲーム (操作: Space=開始/停止, Enter=次へ, C=クリア, Z=戻る)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // 画面中央に配置
        setVisible(true);
    }

    public static void main(String[] args) {
        // Swingのスレッド安全性を確保するための推奨される実行方法
        SwingUtilities.invokeLater(() -> new InteractiveLifeGame());
    }
}

class GamePanel extends JPanel implements ActionListener {
    private final int CELL_SIZE = 20; // セルのサイズ（ピクセル）
    private final int ROWS = 30;     // 行数
    private final int COLS = 30;     // 列数
    private int[][] board = new int[ROWS][COLS]; // 現在の盤面
    private Timer timer;
    private boolean isRunning = false;

    // ? 【コア機能】世代の履歴を保存するアーカイブ（可変長配列）
    private final ArrayList<int[][]> history = new ArrayList<>();

    public GamePanel() {
        // パネルのサイズと背景色の設定
        setPreferredSize(new Dimension(COLS * CELL_SIZE, ROWS * CELL_SIZE));
        setBackground(Color.BLACK);
        
        // 100ミリ秒ごとにactionPerformedを呼び出すタイマー
        timer = new Timer(100, this);
        setFocusable(true); // キーボード入力を受け付けるようにする

        // マウス操作: クリックした場所のセルを反転
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / CELL_SIZE;
                int row = e.getY() / CELL_SIZE;
                
                if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                    // ? 盤面を書き換える前に、現在の状態を履歴に保存！
                    saveToHistory();
                    
                    board[row][col] = (board[row][col] == 1) ? 0 : 1;
                    repaint(); // 画面を再描画
                }
            }
        });

        // キーボード操作の設定
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
                        saveToHistory(); // ? 変化する前に履歴に保存
                        updateBoard();
                        repaint();
                        break;
                        
                    case KeyEvent.VK_C: // Cキーで全消去
                        saveToHistory(); // ? 消去する前に履歴に保存
                        board = new int[ROWS][COLS];
                        isRunning = false;
                        timer.stop();
                        repaint();
                        break;

                    case KeyEvent.VK_Z: // ? 【新機能】Zキーで1手戻る
                        undo();
                        break;
                }
            }
        });
    }

    /**
     * ? 【新機能】現在の盤面を「ディープコピー」して履歴アーカイブに保存する
     */
    private void saveToHistory() {
        int[][] backup = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            // 単に backup[r] = board[r] と書くと参照（リモコン）のコピーになってしまうため、
            // 配列の中身の実データをキッチリ複製（ディープコピー）します。
            System.arraycopy(board[r], 0, backup[r], 0, COLS);
        }
        history.add(backup);
        
        // メモリの肥大化を防ぐため、保存する履歴は最大100世代までにする
        if (history.size() > 100) {
            history.remove(0); // 一番古い履歴を削除
        }
    }

    /**
     * ?? 【新機能】1つ前の世代に盤面を巻き戻す（Undo処理）
     */
    private void undo() {
        // 自動実行中の場合は、バグを防ぐために一度停止させる
        if (isRunning) {
            isRunning = false;
            timer.stop();
        }

        // 履歴が存在するか確認
        if (!history.isEmpty()) {
            // アーカイブの最後（一番最新の履歴）のインデックスを取得
            int lastIndex = history.size() - 1;
            
            // 現在の盤面を、履歴から取得した過去の盤面で上書き
            board = history.get(lastIndex);
            
            // 使用した履歴をアーカイブから削除
            history.remove(lastIndex);
            
            repaint(); // 画面を再描画して反映
            System.out.println("1ステップ巻き戻しました。残りの履歴数: " + history.size());
        } else {
            System.out.println("これ以上戻せません！履歴が空です。");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // グリッド線（補助線）の描画
        g.setColor(Color.DARK_GRAY);
        for (int i = 0; i <= ROWS; i++) g.drawLine(0, i * CELL_SIZE, getWidth(), i * CELL_SIZE);
        for (int i = 0; i <= COLS; i++) g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, getHeight());

        // 生きているセルの描画（シアン色）
        g.setColor(Color.CYAN);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 1) {
                    g.fillRect(c * CELL_SIZE + 1, r * CELL_SIZE + 1, CELL_SIZE - 2, CELL_SIZE - 2);
                }
            }
        }
    }

    // タイマー（100ミリ秒ごと）によって自動的に呼び出されるメソッド
    @Override
    public void actionPerformed(ActionEvent e) {
        saveToHistory(); // ? 自動演化の毎フレームごとに、盤面を履歴に保存
        updateBoard();
        repaint();
    }

    /**
     * 次の世代の盤面を計算するロジック（ライフゲームの基本ルール）
     */
    private void updateBoard() {
        int[][] nextBoard = new int[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int neighbors = countNeighbors(r, c);
                
                if (board[r][c] == 1) {
                    // 生存: 周囲の生存セルが2または3
                    nextBoard[r][c] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                } else {
                    // 誕生: 周囲の生存セルがちょうど3
                    nextBoard[r][c] = (neighbors == 3) ? 1 : 0;
                }
            }
        }
        board = nextBoard;
    }

    /**
     * 指定されたセルの周囲8マスの生きたセルを数える（トーラス構造対応）
     */
    private int countNeighbors(int r, int c) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // 自分自身はカウントしない
                
                // 端と端がつながるようにする処理（％演算子による丸め込み）
                int row = (r + i + ROWS) % ROWS;
                int col = (c + j + COLS) % COLS;
                count += board[row][col];
            }
        }
        return count;
    }
}