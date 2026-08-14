# Experiment Report: Havannah_classic

*Generated: 2026-08-09 12:29:27*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Havannah_classic |
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
| MCVS database key | Havannah_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 18 | 32 | 0 | 50 | 36.0% |
| MAST | 17 | 33 | 0 | 50 | 34.0% |
| RAVE | 38 | 12 | 0 | 50 | 76.0% |
| MCVS | 77 | 73 | 0 | 150 | 51.3% |

| Plies per game | mean = 19.59, min = 9, max = 35 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1147.9 | 1152.0 | 1152.8 | 1347.3 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.480 | 0.000 | 0.520 | 1152.0 | 1147.9 |
| MAST | MCVS | 25 | 0.400 | 0.000 | 0.600 | 1152.8 | 1147.9 |
| MCVS | UCT | 25 | 0.760 | 0.000 | 0.240 | 1147.9 | 1152.0 |
| MCVS | MAST | 25 | 0.720 | 0.000 | 0.280 | 1147.9 | 1152.8 |
| MCVS | RAVE | 25 | 0.280 | 0.000 | 0.720 | 1147.9 | 1347.3 |
| RAVE | MCVS | 25 | 0.800 | 0.000 | 0.200 | 1347.3 | 1147.9 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 2 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 32 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 23 |
| 7 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 27 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 18 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 35 |
| 19 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 22 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 15 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 25 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 26 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 28 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 22 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 32 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 26 |
| 33 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 35 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 36 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 24 |
| 37 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 38 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 18 |
| 39 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 33 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 47 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 17 |
| 49 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 25 |
| 51 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 52 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 16 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 55 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 13 |
| 57 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 60 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 61 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 68 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 20 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 74 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 18 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 80 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 10 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 84 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 23 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 17 |
| 89 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 90 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 24 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 12 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 31 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 19 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 25 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 98 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 26 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 101 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 103 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 104 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 107 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 108 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 109 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 20 |
| 110 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 20 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 25 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 21 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 16 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 19 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 9 |
| 126 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 127 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 129 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 15 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 10 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 134 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 13 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 21 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 13 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 15 |
| 143 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 27 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 14 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 22 |
| 146 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 12 |
| 147 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 19 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 22 |
| 149 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 18 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

