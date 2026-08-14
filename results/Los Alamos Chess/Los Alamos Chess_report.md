# Experiment Report: Los Alamos Chess

*Generated: 2026-08-10 11:15:03*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Los Alamos Chess |
| `.lud` game name | Los Alamos Chess.lud |
| Game options | (default) |

## 2. Agents / Search Algorithms Compared

| Agent | Role |
|---|---|
| UCT | Baseline |
| MAST | Baseline |
| RAVE | Baseline |
| MCVS | Proposed method (Monte Carlo Vector Search) |

## 3. Search Budget and Experimental Hyperparameters

| Parameter | Value |
|---|---|
| Thinking time per move (s) | 1.000 |
| Max iterations per move | unbounded / not used |
| Games per pairing (per colour) | 25 |
| Opponents faced by MCVS | UCT, MAST, RAVE |
| Total games played (this variant) | 150 |
| Elo K-factor | 24.0 |
| MCVS database key | Los Alamos Chess (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 26 | 12 | 12 | 50 | 52.0% |
| MAST | 41 | 4 | 5 | 50 | 82.0% |
| RAVE | 17 | 8 | 25 | 50 | 34.0% |
| MCVS | 24 | 84 | 42 | 150 | 16.0% |

| Plies per game | mean = 73.84, min = 7, max = 150 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1048.7 | 1264.1 | 1339.6 | 1147.6 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.480 | 0.200 | 0.320 | 1264.1 | 1048.7 |
| MAST | MCVS | 25 | 0.880 | 0.080 | 0.040 | 1339.6 | 1048.7 |
| MCVS | UCT | 25 | 0.160 | 0.280 | 0.560 | 1048.7 | 1264.1 |
| MCVS | MAST | 25 | 0.120 | 0.120 | 0.760 | 1048.7 | 1339.6 |
| MCVS | RAVE | 25 | 0.160 | 0.480 | 0.360 | 1048.7 | 1147.6 |
| RAVE | MCVS | 25 | 0.320 | 0.520 | 0.160 | 1147.6 | 1048.7 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 111 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 7 |
| 4 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 117 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 27 |
| 6 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 85 |
| 7 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 117 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 73 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 10 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 11 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 31 |
| 13 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 54 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 20 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 59 |
| 16 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 66 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 56 |
| 20 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 45 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 61 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 80 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 26 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 27 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 87 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 95 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 32 |
| 31 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 32 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 33 | UCT | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 34 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 53 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 56 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 53 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 86 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 46 |
| 40 | MCVS | UCT | 0.500 | 0.0 | 0.0 | 150 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 61 |
| 42 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 80 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 49 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 44 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 66 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 60 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 37 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 24 |
| 50 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 118 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 52 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 37 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 54 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 66 |
| 55 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 58 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 8 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 43 |
| 61 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 51 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 53 |
| 63 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 64 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 66 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 150 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 116 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 36 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 36 |
| 73 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 53 |
| 74 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 76 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 48 |
| 78 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 49 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 38 |
| 80 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 42 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 92 |
| 82 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 52 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 84 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 150 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 86 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 88 | MCVS | MAST | 0.500 | 0.0 | 0.0 | 150 |
| 89 | MAST | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 90 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 24 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 71 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 113 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 95 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 75 |
| 96 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 30 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 93 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 100 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 69 |
| 101 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 40 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 47 |
| 104 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 105 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 59 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 71 |
| 108 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 66 |
| 110 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 112 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 57 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 114 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 115 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 118 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 57 |
| 119 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 55 |
| 120 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 97 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 122 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 60 |
| 123 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 73 |
| 125 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 126 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 32 |
| 128 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 129 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 86 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 55 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 59 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 37 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 136 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 137 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 138 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 43 |
| 139 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 130 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 73 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 55 |
| 142 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 37 |
| 145 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 146 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 150 |
| 147 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 150 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 65 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 102 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

