# Experiment Report: Breakthrough_8x8_connected

*Generated: 2026-08-08 20:24:34*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Breakthrough_8x8_connected |
| `.lud` game name | Breakthrough.lud |
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
| MCVS database key | Breakthrough_8x8_connected (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 11 | 39 | 0 | 50 | 22.0% |
| MAST | 24 | 26 | 0 | 50 | 48.0% |
| RAVE | 40 | 10 | 0 | 50 | 80.0% |
| MCVS | 75 | 75 | 0 | 150 | 50.0% |

| Plies per game | mean = 40.61, min = 12, max = 92 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1138.3 | 1120.6 | 1289.6 | 1251.5 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.240 | 0.000 | 0.760 | 1120.6 | 1138.3 |
| MAST | MCVS | 25 | 0.440 | 0.000 | 0.560 | 1289.6 | 1138.3 |
| MCVS | UCT | 25 | 0.800 | 0.000 | 0.200 | 1138.3 | 1120.6 |
| MCVS | MAST | 25 | 0.480 | 0.000 | 0.520 | 1138.3 | 1289.6 |
| MCVS | RAVE | 25 | 0.240 | 0.000 | 0.760 | 1138.3 | 1251.5 |
| RAVE | MCVS | 25 | 0.840 | 0.000 | 0.160 | 1251.5 | 1138.3 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 49 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 77 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 55 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 42 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 50 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 68 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 37 |
| 17 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 47 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 51 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 45 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 51 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 92 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 39 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 51 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 56 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 59 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 35 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 84 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 70 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 41 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 67 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 38 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 46 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 42 |
| 47 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 57 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 52 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 48 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 58 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 65 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 75 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 55 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 62 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 56 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 64 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 46 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 56 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 36 |
| 71 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 53 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 55 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 55 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 45 |
| 81 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 82 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 54 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 84 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 86 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 42 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 47 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 73 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 78 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 34 |
| 95 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 96 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 28 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 100 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 46 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 47 |
| 104 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 36 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 38 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 114 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 24 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 122 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 126 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 54 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 67 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 59 |
| 134 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 40 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 61 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 73 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 61 |
| 138 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 35 |
| 139 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 142 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 54 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 65 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 49 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 47 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 148 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 31 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 48 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

