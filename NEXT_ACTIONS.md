# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 0/176 (0.0%)
- **Function parity:** 0/1048 matched — 0.0%
- **Class/type parity:** 0/232 matched — 0.0%
- **Combined symbol parity:** 0/1280 matched — 0.0%
- **Average inline-code cosine:** 0.00 (function body across 0 matched files)
- **Average documentation cosine:** 0.00 (doc text across 0 matched files)
- **Cheat-zeroed Files:** 0
- **Critical Issues:** 0 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

No incomplete high-dependency files detected.

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

1. **parse.error** (22 deps)
   - Path: `revision/spec/parse/error.rs`
   - Essential for 22 other files

2. **ext.object_id** (17 deps)
   - Path: `ext/object_id.rs`
   - Essential for 17 other files

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

## Next Commands

```bash
# Initialize task queue for systematic porting
cd tools/ast_distance
./ast_distance --init-tasks ../../tmp/gix/src rust ../../src/commonMain/kotlin/io/github/kotlinmania/gix kotlin tasks.json ../../AGENTS.md

# Get next high-priority task
./ast_distance --assign tasks.json <agent-id>
```
## Reexport / Wiring Modules

These files match `reexport_modules` patterns in `.ast_distance_config.json`. They are filtered out of
normal priority and missing-file ladders because they are wiring
modules, not direct logic ports. Consult them for call-site routing;
do not treat them as the next implementation target by default.

### Missing

| Source | Expected target | Deps | Source path | Expected path |
|--------|-----------------|------|-------------|---------------|
| `fetch.mod` | `clone.fetch.Mod` | 0 | `clone/fetch/mod.rs` | `clone/fetch/Mod.kt` |
| `clone.mod` | `clone.Mod` | 0 | `clone/mod.rs` | `clone/Mod.kt` |
| `cache.mod` | `config.cache.Mod` | 0 | `config/cache/mod.rs` | `config/cache/Mod.kt` |
| `config.mod` | `config.Mod` | 0 | `config/mod.rs` | `config/Mod.kt` |
| `snapshot.mod` | `config.snapshot.Mod` | 0 | `config/snapshot/mod.rs` | `config/snapshot/Mod.kt` |
| `config.tree.mod` | `config.tree.Mod` | 0 | `config/tree/mod.rs` | `config/tree/Mod.kt` |
| `sections.mod` | `config.tree.sections.Mod` | 0 | `config/tree/sections/mod.rs` | `config/tree/sections/Mod.kt` |
| `dirwalk.mod` | `dirwalk.Mod` | 0 | `dirwalk/mod.rs` | `dirwalk/Mod.kt` |
| `ext.mod` | `ext.Mod` | 0 | `ext/mod.rs` | `ext/Mod.kt` |
| `head.mod` | `head.Mod` | 0 | `head/mod.rs` | `head/Mod.kt` |
| `lib` | `Lib` | 0 | `lib.rs` | `Lib.kt` |
| `object.mod` | `object.Mod` | 0 | `object/mod.rs` | `object/Mod.kt` |
| `diff.mod` | `object.tree.diff.Mod` | 0 | `object/tree/diff/mod.rs` | `object/tree/diff/Mod.kt` |
| `tree.mod` | `object.tree.Mod` | 0 | `object/tree/mod.rs` | `object/tree/Mod.kt` |
| `open.mod` | `open.Mod` | 0 | `open/mod.rs` | `open/Mod.kt` |
| `reference.mod` | `reference.Mod` | 0 | `reference/mod.rs` | `reference/Mod.kt` |
| `remote.connection.fetch.mod` | `remote.connection.fetch.Mod` | 0 | `remote/connection/fetch/mod.rs` | `remote/connection/fetch/Mod.kt` |
| `update_refs.mod` | `remote.connection.fetch.updaterefs.Mod` | 0 | `remote/connection/fetch/update_refs/mod.rs` | `remote/connection/fetch/updaterefs/Mod.kt` |
| `connection.mod` | `remote.connection.Mod` | 0 | `remote/connection/mod.rs` | `remote/connection/Mod.kt` |
| `remote.mod` | `remote.Mod` | 0 | `remote/mod.rs` | `remote/Mod.kt` |
| `url.mod` | `remote.url.Mod` | 0 | `remote/url/mod.rs` | `remote/url/Mod.kt` |
| `repository.config.mod` | `repository.config.Mod` | 0 | `repository/config/mod.rs` | `repository/config/Mod.kt` |
| `repository.mod` | `repository.Mod` | 0 | `repository/mod.rs` | `repository/Mod.kt` |
| `revision.mod` | `revision.Mod` | 0 | `revision/mod.rs` | `revision/Mod.kt` |
| `spec.mod` | `revision.spec.Mod` | 0 | `revision/spec/mod.rs` | `revision/spec/Mod.kt` |
| `delegate.mod` | `revision.spec.parse.delegate.Mod` | 0 | `revision/spec/parse/delegate/mod.rs` | `revision/spec/parse/delegate/Mod.kt` |
| `parse.mod` | `revision.spec.parse.Mod` | 0 | `revision/spec/parse/mod.rs` | `revision/spec/parse/Mod.kt` |
| `iter.mod` | `status.iter.Mod` | 0 | `status/iter/mod.rs` | `status/iter/Mod.kt` |
| `status.mod` | `status.Mod` | 0 | `status/mod.rs` | `status/Mod.kt` |
| `submodule.mod` | `submodule.Mod` | 0 | `submodule/mod.rs` | `submodule/Mod.kt` |
| `worktree.mod` | `worktree.Mod` | 0 | `worktree/mod.rs` | `worktree/Mod.kt` |

