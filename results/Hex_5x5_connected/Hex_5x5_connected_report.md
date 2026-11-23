# Experiment Report: Hex_5x5_connected

*Generated: 2026-08-09 01:05:56*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Hex_5x5_connected |
| `.lud` game name | Hex.lud |
| Game options | Board Size/5x5 |

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
| MCVS database key | Hex_5x5_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 8 | 42 | 0 | 50 | 16.0% |
| MAST | 11 | 39 | 0 | 50 | 22.0% |
| RAVE | 17 | 33 | 0 | 50 | 34.0% |
| MCVS | 114 | 36 | 0 | 150 | 76.0% |

| Plies per game | mean = 10.24, min = 9, max = 17 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1337.9 | 1075.3 | 1153.0 | 1233.8 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.320 | 0.000 | 0.680 | 1075.3 | 1337.9 |
| MAST | MCVS | 25 | 0.400 | 0.000 | 0.600 | 1153.0 | 1337.9 |
| MCVS | UCT | 25 | 1.000 | 0.000 | 0.000 | 1337.9 | 1075.3 |
| MCVS | MAST | 25 | 0.960 | 0.000 | 0.040 | 1337.9 | 1153.0 |
| MCVS | RAVE | 25 | 0.880 | 0.000 | 0.120 | 1337.9 | 1233.8 |
| RAVE | MCVS | 25 | 0.560 | 0.000 | 0.440 | 1233.8 | 1337.9 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 11 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 11 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 11 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 64 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 10 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 73 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 10 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 102 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 107 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 10 |
| 113 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 11 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 10 |
| 129 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 130 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 138 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 10 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 9 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

