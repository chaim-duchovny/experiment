# Experiment Report: Havannah_connected

*Generated: 2026-08-09 13:22:29*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Havannah_connected |
| `.lud` game name | Havannah.lud |
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
| MCVS database key | Havannah_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 17 | 33 | 0 | 50 | 34.0% |
| MAST | 20 | 30 | 0 | 50 | 40.0% |
| RAVE | 37 | 13 | 0 | 50 | 74.0% |
| MCVS | 76 | 74 | 0 | 150 | 50.7% |

| Plies per game | mean = 21.11, min = 10, max = 41 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1146.3 | 1177.6 | 1170.2 | 1305.8 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.480 | 0.000 | 0.520 | 1177.6 | 1146.3 |
| MAST | MCVS | 25 | 0.520 | 0.000 | 0.480 | 1170.2 | 1146.3 |
| MCVS | UCT | 25 | 0.800 | 0.000 | 0.200 | 1146.3 | 1177.6 |
| MCVS | MAST | 25 | 0.720 | 0.000 | 0.280 | 1146.3 | 1170.2 |
| MCVS | RAVE | 25 | 0.440 | 0.000 | 0.560 | 1146.3 | 1305.8 |
| RAVE | MCVS | 25 | 0.920 | 0.000 | 0.080 | 1305.8 | 1146.3 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 39 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 10 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 18 |
| 11 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 24 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 30 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 30 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 43 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 48 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 36 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 50 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 20 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 52 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 55 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 61 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 14 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 82 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 91 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 12 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 35 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 18 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 102 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 114 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 24 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 125 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 12 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 23 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 25 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 134 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 136 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 24 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 10 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 17 |
| 143 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 25 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

