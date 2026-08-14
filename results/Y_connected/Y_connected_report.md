# Experiment Report: Y_connected

*Generated: 2026-08-09 20:54:41*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Y_connected |
| `.lud` game name | Y.lud |
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
| MCVS database key | Y_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 12 | 38 | 0 | 50 | 24.0% |
| MAST | 14 | 36 | 0 | 50 | 28.0% |
| RAVE | 35 | 15 | 0 | 50 | 70.0% |
| MCVS | 89 | 61 | 0 | 150 | 59.3% |

| Plies per game | mean = 30.01, min = 21, max = 43 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1219.4 | 1071.0 | 1163.0 | 1346.6 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.320 | 0.000 | 0.680 | 1071.0 | 1219.4 |
| MAST | MCVS | 25 | 0.320 | 0.000 | 0.680 | 1163.0 | 1219.4 |
| MCVS | UCT | 25 | 0.840 | 0.000 | 0.160 | 1219.4 | 1071.0 |
| MCVS | MAST | 25 | 0.760 | 0.000 | 0.240 | 1219.4 | 1163.0 |
| MCVS | RAVE | 25 | 0.320 | 0.000 | 0.680 | 1219.4 | 1346.6 |
| RAVE | MCVS | 25 | 0.720 | 0.000 | 0.280 | 1346.6 | 1219.4 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 34 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 30 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 32 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 34 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 37 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 42 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 24 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 39 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 52 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 54 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 28 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 57 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 35 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 28 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 74 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 76 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 101 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 42 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 104 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 35 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 38 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 35 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 125 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 126 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 136 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 36 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 35 |
| 143 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 149 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 30 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

