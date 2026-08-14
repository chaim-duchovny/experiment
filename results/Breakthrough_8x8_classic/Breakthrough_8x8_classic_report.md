# Experiment Report: Breakthrough_8x8_classic

*Generated: 2026-08-09 00:14:15*

## 1. Game Configuration

| Parameter | Value |
|---|---|
| Game engine | Ludii |
| Display name | Breakthrough_8x8_classic |
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
| MCVS database key | Breakthrough_8x8_classic (persistent, shared across all pairings for this variant, independent of other game variants) |
| Random seed | not fixed / not logged by this runner |

## 4. Aggregate Results

| Player | Wins | Losses | Draws | Games | Win rate |
|---|---|---|---|---|---|
| UCT | 10 | 40 | 0 | 50 | 20.0% |
| MAST | 15 | 35 | 0 | 50 | 30.0% |
| RAVE | 24 | 26 | 0 | 50 | 48.0% |
| MCVS | 101 | 49 | 0 | 150 | 67.3% |

| Plies per game | mean = 44.93, min = 11, max = 88 | | | | |

| Final Elo (MCVS) | Final Elo (UCT) | Final Elo (MAST) | Final Elo (RAVE) |
|---|---|---|
| 1358.2 | 1038.6 | 1173.5 | 1229.7 |

## 5. Pairwise Summary

| player_a | player_b | games | win_rate_a | draw_rate | loss_rate_a | final_elo_a | final_elo_b |
|---|---|---|---|---|---|---|---|
| UCT | MCVS | 25 | 0.160 | 0.000 | 0.840 | 1038.6 | 1358.2 |
| MAST | MCVS | 25 | 0.280 | 0.000 | 0.720 | 1173.5 | 1358.2 |
| MCVS | UCT | 25 | 0.760 | 0.000 | 0.240 | 1358.2 | 1038.6 |
| MCVS | MAST | 25 | 0.680 | 0.000 | 0.320 | 1358.2 | 1173.5 |
| MCVS | RAVE | 25 | 0.520 | 0.000 | 0.480 | 1358.2 | 1229.7 |
| RAVE | MCVS | 25 | 0.480 | 0.000 | 0.520 | 1229.7 | 1358.2 |

## 6. Learning Curve (Game-by-Game)

| game_index | player_a | player_b | score_a | elo_a | elo_b | plies |
|---|---|---|---|---|---|---|
| 1 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 38 |
| 2 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 53 |
| 3 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 45 |
| 4 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 21 |
| 5 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 43 |
| 6 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 7 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 8 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 40 |
| 9 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 77 |
| 10 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 45 |
| 11 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 60 |
| 12 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 22 |
| 13 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 14 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 45 |
| 15 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 16 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 47 |
| 17 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 18 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 44 |
| 19 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 20 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 45 |
| 21 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 56 |
| 22 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 64 |
| 23 | UCT | MCVS | 1.000 | 0.0 | 0.0 | 57 |
| 24 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 42 |
| 25 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 26 | MCVS | UCT | 0.000 | 0.0 | 0.0 | 46 |
| 27 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 68 |
| 28 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 57 |
| 29 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 66 |
| 30 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 31 |
| 31 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 58 |
| 32 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 19 |
| 33 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 34 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 43 |
| 35 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 36 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 51 |
| 37 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 52 |
| 38 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 49 |
| 39 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 40 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 39 |
| 41 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 28 |
| 42 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 53 |
| 43 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 30 |
| 44 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 57 |
| 45 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 46 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 41 |
| 47 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 54 |
| 48 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 13 |
| 49 | UCT | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 50 | MCVS | UCT | 1.000 | 0.0 | 0.0 | 39 |
| 51 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 52 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 53 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 39 |
| 54 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 61 |
| 55 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 14 |
| 56 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 46 |
| 57 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 58 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 59 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 60 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 44 |
| 61 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 62 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 63 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 34 |
| 64 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 15 |
| 65 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 66 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 67 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 51 |
| 68 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 36 |
| 69 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 70 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 40 |
| 71 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 44 |
| 72 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 21 |
| 73 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 45 |
| 74 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 62 |
| 75 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 76 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 51 |
| 77 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 53 |
| 78 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 70 |
| 79 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 40 |
| 80 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 33 |
| 81 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 82 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 37 |
| 83 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 84 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 64 |
| 85 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 51 |
| 86 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 43 |
| 87 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 88 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 35 |
| 89 | MAST | MCVS | 1.000 | 0.0 | 0.0 | 45 |
| 90 | MCVS | MAST | 0.000 | 0.0 | 0.0 | 50 |
| 91 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 92 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 51 |
| 93 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 16 |
| 94 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 31 |
| 95 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 88 |
| 96 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 41 |
| 97 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 98 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 69 |
| 99 | MAST | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 100 | MCVS | MAST | 1.000 | 0.0 | 0.0 | 29 |
| 101 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 60 |
| 102 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 28 |
| 103 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 50 |
| 104 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 46 |
| 105 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 106 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 62 |
| 107 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 41 |
| 108 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 53 |
| 109 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 110 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 47 |
| 111 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 45 |
| 112 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 78 |
| 113 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 114 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 37 |
| 115 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 11 |
| 116 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 64 |
| 117 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 59 |
| 118 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 39 |
| 119 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 17 |
| 120 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 60 |
| 121 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 71 |
| 122 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 57 |
| 123 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 46 |
| 124 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 60 |
| 125 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 53 |
| 126 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 60 |
| 127 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 55 |
| 128 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 38 |
| 129 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 48 |
| 130 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 48 |
| 131 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 67 |
| 132 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 39 |
| 133 | RAVE | MCVS | 1.000 | 0.0 | 0.0 | 23 |
| 134 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 75 |
| 135 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 66 |
| 136 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 137 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 76 |
| 138 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 77 |
| 139 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 24 |
| 140 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 43 |
| 141 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 42 |
| 142 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 45 |
| 143 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 32 |
| 144 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 65 |
| 145 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 78 |
| 146 | MCVS | RAVE | 1.000 | 0.0 | 0.0 | 63 |
| 147 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 148 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 40 |
| 149 | RAVE | MCVS | 0.000 | 0.0 | 0.0 | 36 |
| 150 | MCVS | RAVE | 0.000 | 0.0 | 0.0 | 68 |

## 7. MCVS Database Quality Snapshots

Background evaluations that periodically freeze a snapshot of the shared MCVS database and grade it against UCT on a separate thread, without pausing the main experiment loop.

| snapshot_games | snapshot_size | games_played | mcvs_wins | mcvs_draws | mcvs_losses | mcvs_win_rate |
|---|---|---|---|---|---|---|

## 8. Reproducibility Notes

- Random seed: not fixed by `ExperimentRunner`; set one explicitly (e.g. via the JVM or the game engine's RNG) before re-running if exact game-by-game reproduction is required.
- Hardware / JVM version / OS: not captured automatically; record these manually for the paper.
- The MCVS database accumulates across all pairings for this game variant and is reset only when a new variant begins, so later games in the learning curve benefit from a database built up over earlier games against both opponents.
- Elo ratings are computed online, in play order, with a fixed K-factor (see Section 3); they are relative to this run only and not calibrated against any external rating pool.

