# Experiment Report: Hex_7x7_classic

*Generated: 2026-08-09 01:51:03*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Hex_7x7_classic |
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
| MCVS database key | Hex_7x7_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 17 | 33 | 0 | 50 | 34.0% |
| MAST | 22 | 28 | 0 | 50 | 44.0% |
| RAVE | 38 | 12 | 0 | 50 | 76.0% |
| MCVS | 73 | 77 | 0 | 150 | 48.7% |

| Plies per game | mean = 17.96, min = 13, max = 32 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1162.5 | 1166.7 | 1187.0 | 1283.9 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.480 | 0.000 | 0.520 | 1166.7 | 1162.5 |
| MAST | MCVS | 25 | 0.520 | 0.000 | 0.480 | 1187.0 | 1162.5 |
| MCVS | UCT | 25 | 0.800 | 0.000 | 0.200 | 1162.5 | 1166.7 |
| MCVS | MAST | 25 | 0.640 | 0.000 | 0.360 | 1162.5 | 1187.0 |
| MCVS | RAVE | 25 | 0.400 | 0.000 | 0.600 | 1162.5 | 1283.9 |
| RAVE | MCVS | 25 | 0.920 | 0.000 | 0.080 | 1283.9 | 1162.5 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 14 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 19 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 18 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 29 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 20 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 21 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 40 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 16 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 42 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 16 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 20 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 18 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 55 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 58 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 61 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 63 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 19 |
| 66 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 14 |
| 73 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 78 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 14 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 80 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 22 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 83 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 86 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 90 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 100 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 14 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 32 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 112 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 23 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 18 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 122 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 25 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 16 |
| 136 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 25 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 23 |
| 149 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

