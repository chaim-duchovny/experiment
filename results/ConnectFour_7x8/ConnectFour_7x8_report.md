# Experiment Report: ConnectFour_7x8

*Generated: 2026-08-09 11:40:17*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | ConnectFour_7x8 |
| `.lud` game name | Connect Four.lud |
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
| MCVS database key | ConnectFour_7x8 (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 2 | 48 | 0 | 50 | 4.0% |
| MAST | 4 | 46 | 0 | 50 | 8.0% |
| RAVE | 30 | 18 | 2 | 50 | 60.0% |
| MCVS | 112 | 36 | 2 | 150 | 74.7% |

| Plies per game | mean = 20.24, min = 7, max = 44 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1312.6 | 1007.7 | 1110.1 | 1369.6 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.080 | 0.000 | 0.920 | 1007.7 | 1312.6 |
| MAST | MCVS | 25 | 0.160 | 0.000 | 0.840 | 1110.1 | 1312.6 |
| MCVS | UCT | 25 | 1.000 | 0.000 | 0.000 | 1312.6 | 1007.7 |
| MCVS | MAST | 25 | 1.000 | 0.000 | 0.000 | 1312.6 | 1110.1 |
| MCVS | RAVE | 25 | 0.520 | 0.040 | 0.440 | 1312.6 | 1369.6 |
| RAVE | MCVS | 25 | 0.760 | 0.040 | 0.200 | 1369.6 | 1312.6 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 9 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 7 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 9 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 7 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 10 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 8 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 101 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 37 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 34 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 34 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 114 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 34 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 36 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 31 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 127 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 130 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 39 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 132 | MCVS | RAVE | 0.500 | 0.0 | 0.0 | 44 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 44 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 138 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 139 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 42 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 27 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 37 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 34 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 39 |
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

