# Experiment Report: Y_classic

*Generated: 2026-08-09 19:39:05*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Y_classic |
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
| MCVS database key | Y_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 17 | 33 | 0 | 50 | 34.0% |
| MAST | 14 | 36 | 0 | 50 | 28.0% |
| RAVE | 42 | 8 | 0 | 50 | 84.0% |
| MCVS | 77 | 73 | 0 | 150 | 51.3% |

| Plies per game | mean = 29.81, min = 21, max = 43 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1108.7 | 1153.3 | 1151.1 | 1386.9 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.440 | 0.000 | 0.560 | 1153.3 | 1108.7 |
| MAST | MCVS | 25 | 0.280 | 0.000 | 0.720 | 1151.1 | 1108.7 |
| MCVS | UCT | 25 | 0.760 | 0.000 | 0.240 | 1108.7 | 1153.3 |
| MCVS | MAST | 25 | 0.720 | 0.000 | 0.280 | 1108.7 | 1151.1 |
| MCVS | RAVE | 25 | 0.200 | 0.000 | 0.800 | 1108.7 | 1386.9 |
| RAVE | MCVS | 25 | 0.880 | 0.000 | 0.120 | 1386.9 | 1108.7 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 30 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 34 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 14 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 30 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 27 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 32 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 32 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 29 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 43 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 44 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 28 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 50 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 22 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 56 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 30 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 32 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 62 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 64 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 38 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 70 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 72 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 30 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 26 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 39 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 27 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 28 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 99 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 33 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 37 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 30 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 114 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 30 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 118 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 40 |
| 119 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 36 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 122 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 34 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 29 |
| 126 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 30 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 130 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 134 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 136 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 40 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 35 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 140 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 26 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 29 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 36 |
| 145 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 33 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 37 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 32 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

