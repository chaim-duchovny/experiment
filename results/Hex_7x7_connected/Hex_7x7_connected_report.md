# Experiment Report: Hex_7x7_connected

*Generated: 2026-08-09 02:36:44*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Hex_7x7_connected |
| `.lud` game name | Hex.lud |
| Game options | Board Size/7x7 |

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
| MCVS database key | Hex_7x7_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 11 | 39 | 0 | 50 | 22.0% |
| MAST | 19 | 31 | 0 | 50 | 38.0% |
| RAVE | 29 | 21 | 0 | 50 | 58.0% |
| MCVS | 91 | 59 | 0 | 150 | 60.7% |

| Plies per game | mean = 18.17, min = 13, max = 32 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1213.2 | 1079.4 | 1195.9 | 1311.5 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.240 | 0.000 | 0.760 | 1079.4 | 1213.2 |
| MAST | MCVS | 25 | 0.680 | 0.000 | 0.320 | 1195.9 | 1213.2 |
| MCVS | UCT | 25 | 0.800 | 0.000 | 0.200 | 1213.2 | 1079.4 |
| MCVS | MAST | 25 | 0.920 | 0.000 | 0.080 | 1213.2 | 1195.9 |
| MCVS | RAVE | 25 | 0.440 | 0.000 | 0.560 | 1213.2 | 1311.5 |
| RAVE | MCVS | 25 | 0.600 | 0.000 | 0.400 | 1311.5 | 1213.2 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 22 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 6 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 14 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 14 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 20 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 25 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 33 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 24 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 17 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 55 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 57 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 62 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 66 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 16 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 73 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 16 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 22 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 17 |
| 105 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 25 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 107 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 111 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 25 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 23 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 17 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 122 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 15 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 17 |
| 125 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 17 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 134 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 135 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 142 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 23 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 18 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

