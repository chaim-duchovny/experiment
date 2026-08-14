# Experiment Report: Reversi8x8

*Generated: 2026-08-09 15:52:52*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Reversi8x8 |
| `.lud` game name | Reversi.lud |
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
| MCVS database key | Reversi8x8 (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 7 | 43 | 0 | 50 | 14.0% |
| MAST | 26 | 24 | 0 | 50 | 52.0% |
| RAVE | 13 | 34 | 3 | 50 | 26.0% |
| MCVS | 101 | 46 | 3 | 150 | 67.3% |

| Plies per game | mean = 62.46, min = 11, max = 70 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1289.1 | 1060.9 | 1290.6 | 1159.4 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.160 | 0.000 | 0.840 | 1060.9 | 1289.1 |
| MAST | MCVS | 25 | 0.400 | 0.000 | 0.600 | 1290.6 | 1289.1 |
| MCVS | UCT | 25 | 0.880 | 0.000 | 0.120 | 1289.1 | 1060.9 |
| MCVS | MAST | 25 | 0.360 | 0.000 | 0.640 | 1289.1 | 1290.6 |
| MCVS | RAVE | 25 | 0.800 | 0.000 | 0.200 | 1289.1 | 1159.4 |
| RAVE | MCVS | 25 | 0.320 | 0.120 | 0.560 | 1159.4 | 1289.1 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 66 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 3 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 4 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 64 |
| 5 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 8 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 70 |
| 9 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 64 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 12 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 62 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 65 |
| 15 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 61 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 18 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 64 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 65 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 62 |
| 23 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 24 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 26 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 62 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 64 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 62 |
| 31 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 62 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 65 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 62 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 41 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 64 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 45 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 69 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 62 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 63 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 53 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 54 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 56 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 58 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 59 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 64 |
| 61 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 62 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 63 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 65 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 67 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 69 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 64 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 73 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 74 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 64 |
| 75 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 76 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 77 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 65 |
| 78 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 11 |
| 79 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 80 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 82 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 84 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 63 |
| 85 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 86 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 87 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 88 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 90 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 92 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 63 |
| 93 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 94 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 96 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 97 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 62 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 100 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 66 |
| 101 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 64 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 63 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 104 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 105 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 106 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 107 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 62 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 109 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 111 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 62 |
| 112 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 65 |
| 113 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 64 |
| 115 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 116 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 65 |
| 117 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 120 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 121 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 123 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 124 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 64 |
| 125 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 126 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 127 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 128 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 129 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 130 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 131 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 132 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 62 |
| 133 | RAVE | MCVS | 0.500 | 0.0 | 0.0 | 62 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 64 |
| 135 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 67 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 137 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 62 |
| 138 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 62 |
| 139 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 62 |
| 141 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 63 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 144 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 62 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 62 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 147 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 64 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 62 |
| 149 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 63 |
| 150 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

