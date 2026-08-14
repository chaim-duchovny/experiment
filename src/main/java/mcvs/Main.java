package mcvs;

import java.nio.file.Path;
import java.util.List;

import mcvs.experiment.ExperimentRunner;
import mcvs.experiment.ExperimentRunner.AIFactory;
import mcvs.experiment.ExperimentRunner.GameSpec;
import mcvs.search.MASTPlayer;
import mcvs.search.RAVEPlayer;
import mcvs.search.MCVSPlayer;
import mcvs.search.UCTPlayer;
import other.AI;

/**
 * Entry point: runs the MCVS vs. UCT vs. MAST tournament described in the paper's
 * "Monte Carlo Vector Search (MCVS)" section, on the Ludii General Game Playing
 * System. Hex is used as the primary test game (per the paper's experimental
 * priority), followed by Breakthrough and English Draughts.
 *
 * <p>Usage:
 * <pre>
 *   java -cp mcvs-experiments.jar mcvs.Main [gamesPerPairing] [thinkingSeconds] [maxIterations]
 * </pre>
 */
public final class Main {

    private Main() {}

    public static void main(String[] args) throws Exception {
        System.out.println("MCVSPlayer comes from: " + 
            mcvs.search.MCVSPlayer.class.getProtectionDomain().getCodeSource().getLocation());
        final int gamesPerPairing = args.length > 0 ? Integer.parseInt(args[0]) : 100;
        final double thinkingSeconds = args.length > 1 ? Double.parseDouble(args[1]) : 1.0;
        final int maxIterations = args.length > 2 ? Integer.parseInt(args[2]) : -1;

        final List<GameSpec> games = List.of(
                //new GameSpec("Breakthrough_8x8_connected", "Breakthrough.lud", List.of()),
                //new GameSpec("Breakthrough_8x8_classic", "Breakthrough.lud", List.of()),
                //new GameSpec("Hex_5x5_classic",   "Hex.lud", List.of("Board Size/5x5")),
                //new GameSpec("Hex_5x5_connected", "Hex.lud", List.of("Board Size/5x5")),
                //new GameSpec("Hex_7x7_classic",   "Hex.lud", List.of("Board Size/7x7")),
                //new GameSpec("Hex_7x7_connected", "Hex.lud", List.of("Board Size/7x7")),
                //new GameSpec("EnglishDraughts_8x8", "English Draughts.lud", List.of()),
                //new GameSpec("ConnectFour_7x8", "Connect Four.lud", List.of()),
                //new GameSpec("Havannah_classic", "Havannah.lud", List.of("Board Size/5x5")),
                //new GameSpec("Havannah_connected", "Havannah.lud", List.of("Board Size/5x5")),
                //new GameSpec("Reversi8x8", "Reversi.lud", List.of()),
                //new GameSpec("Los Alamos Chess", "Los Alamos Chess.lud", List.of())
                //new GameSpec("Y_classic", "Y.lud", List.of()),
                //new GameSpec("Y_connected", "Y.lud", List.of())
                //new GameSpec("Amazons", "Amazons.lud", List.of())
                //new GameSpec("Go9x9_classic", "Go.lud", List.of("Board Size/9x9")),
                //new GameSpec("Go9x9_connected", "Go.lud", List.of("Board Size/9x9")),
                //new GameSpec("Go13x13_classic", "Go.lud", List.of("Board Size/13x13")),
                //new GameSpec("Go13x13_connected", "Go.lud", List.of("Board Size/13x13"))
            );

        final List<AIFactory> aiFactories = List.of(
            new AIFactory() {
                @Override public AI create() { return new UCTPlayer(); }
                @Override public String name() { return "UCT"; }
            },
            new AIFactory() {
                @Override public AI create() { return new MASTPlayer(); }
                @Override public String name() { return "MAST"; }
            },
            new AIFactory() {
                @Override public AI create() { return new MCVSPlayer(); }  // index 2 = real MCVS
                @Override public String name() { return "MCVS"; }
            },
            new AIFactory() {
                @Override public AI create() { return new RAVEPlayer(); }  // index 3 = real RAVE
                @Override public String name() { return "RAVE"; }
            });

        final ExperimentRunner runner = new ExperimentRunner(
                games, aiFactories, gamesPerPairing, thinkingSeconds, maxIterations, Path.of("results"));
        runner.run();
    }
}
