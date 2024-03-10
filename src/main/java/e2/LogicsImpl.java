package e2;

import java.util.Random;
import java.util.function.Function;

public class LogicsImpl implements Logics {
    NeighbourList<Cell> board;

    public LogicsImpl(int size, Function<Pair<Integer, Integer>, Boolean> minePlacingAlgorithm) {
        this.board = new NeighbourListImpl<>(
                new Pair<>(size, size),
                (p) -> java.util.Optional.of(new CellImpl(minePlacingAlgorithm.apply(p)))
        );
    }

    @Override
    public boolean hasMine(Pair<Integer, Integer> minePosition) {
        return this.board.get(minePosition).get().hasMine();
    }

    @Override
    public void flag(Pair<Integer, Integer> cellPosition) {
        this.board.get(cellPosition).get().flag();
    }

    @Override
    public boolean isFlagged(Pair<Integer, Integer> cellPosition) {
        return this.board.get(cellPosition).get().isFlagged();
    }

    @Override
    public int getNumberOfNeighbouringMines(Pair<Integer, Integer> position) {
        return 0;
    }
}
