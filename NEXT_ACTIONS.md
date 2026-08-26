# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 28/176 (15.9%)
- **Function parity:** 20/1062 matched (target 59) — 1.9%
- **Class/type parity:** 22/237 matched (target 135) — 9.3%
- **Combined symbol parity:** 42/1299 matched (target 194) — 3.2%
- **Average inline-code cosine:** 0.35 (function body across 26 matched files)
- **Average documentation cosine:** 0.45 (doc text across 26 matched files)
- **Cheat-zeroed Files:** 7
- **Critical Issues:** 21 files with <0.60 function similarity

## Priority 1: Fix Incomplete High-Dependency Files

### 1. parse.error
- **Similarity:** 0.00 (needs 85% improvement)
- **Dependencies:** 22
- **Priority Score:** 22030410.0
- **Functions:** 0/2 matched (target 1)
- **Missing functions:** `fmt`, `ambiguous`
- **Types:** 1/2 matched (target 5)
- **Missing types:** `Order`
- **Symbol Deficit:** 3 (functions: 2, types: 1)
- **Action:** Deep review - likely missing major functionality

### 2. ext.object_id
- **Similarity:** 0.49 (needs 36% improvement)
- **Dependencies:** 17
- **Priority Score:** 17040506.0
- **Functions:** 1/2 matched (target 1)
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 0)
- **Missing types:** `Sealed`, `AncestorsIter`, `ObjectIdExt`
- **Symbol Deficit:** 4 (functions: 1, types: 3)
- **Action:** Deep review - likely missing major functionality

## Priority 2: Port Missing High-Value Files

Critical missing files (>10 dependencies):

No missing high-value files detected.

## Detailed Work Items

Every matched file is listed below with function and type symbol parity.

### 1. parse.error

- **Target:** `parse.Error`
- **Similarity:** 0.00
- **Dependents:** 22
- **Priority Score:** 22030410.0
- **Functions:** 0/2 matched (target 1)
- **Missing functions:** `fmt`, `ambiguous`
- **Types:** 1/2 matched (target 5)
- **Missing types:** `Order`

### 2. ext.object_id

- **Target:** `ext.ObjectId`
- **Similarity:** 0.49
- **Dependents:** 17
- **Priority Score:** 17040506.0
- **Functions:** 1/2 matched (target 1)
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 0)
- **Missing types:** `Sealed`, `AncestorsIter`, `ObjectIdExt`

### 3. ext.tree

- **Target:** `ext.Tree`
- **Similarity:** 0.51
- **Dependents:** 5
- **Priority Score:** 5060705.0
- **Functions:** 1/2 matched
- **Missing functions:** `traverse`
- **Types:** 0/5 matched (target 2)
- **Missing types:** `Sealed`, `TreeIterExt`, `TreeEntryRefExt`, `TreeEntryExt`, `TreeDiffChangeExt`

### 4. attribute_stack

- **Target:** `gix.AttributeStack`
- **Similarity:** 0.07
- **Dependents:** 2
- **Priority Score:** 2060709.2
- **Functions:** 1/6 matched (target 2)
- **Missing functions:** `new`, `detach`, `deref`, `deref_mut`, `at_entry`
- **Types:** 0/1 matched
- **Missing types:** `Target`

### 5. path

- **Target:** `gix.Path`
- **Similarity:** 0.00
- **Dependents:** 2
- **Priority Score:** 2010110.0
- **Functions:** 0/1 matched (target 3)
- **Missing functions:** `install_dir`
- **Types:** 0/0 matched (target 1)
- **Missing types:** _none_

### 6. state

- **Target:** `gix.State`
- **Similarity:** 1.00
- **Dependents:** 2
- **Priority Score:** 2000100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 1/1 matched
- **Missing types:** _none_

### 7. id

- **Target:** `gix.Id`
- **Similarity:** 0.11
- **Dependents:** 1
- **Priority Score:** 1162008.9
- **Functions:** 4/18 matched (target 6)
- **Missing functions:** `object`, `header`, `try_object`, `try_header`, `calculate_auto_hex_len`, `deref`, `ancestors`, `hash`, `partial_cmp`, `eq`, `fmt`, `as_ref`, `from`, `size_of_oid`
- **Types:** 0/2 matched (target 1)
- **Missing types:** `Error`, `Target`
- **Tests:** 0/1 matched

### 8. ext.reference

- **Target:** `ext.Reference`
- **Similarity:** 0.83
- **Dependents:** 1
- **Priority Score:** 1010201.7
- **Functions:** 1/1 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 0)
- **Missing types:** `ReferenceExt`

### 9. progress

- **Target:** `gix.Progress [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 1
- **Priority Score:** 1000010.0
- **Functions:** 0/0 matched (target 4)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_
- **Lint issues:** 3

### 10. object.mod

- **Target:** `objs.Kind [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 232310.0
- **Functions:** 0/22 matched (target 0)
- **Missing functions:** `attach`, `fmt`, `from_data`, `into_blob`, `into_tree`, `into_commit`, `into_tag`, `try_into_commit`, `try_into_tag`, `try_into_tree`, `try_into_blob`, `detached`, `detach`, `to_commit_ref`, `try_to_commit_ref`, `to_commit_ref_iter`, `try_to_commit_ref_iter`, `to_tag_ref_iter`, `try_to_tag_ref_iter`, `to_tag_ref`, `try_to_tag_ref`, `id`
- **Types:** 0/1 matched
- **Missing types:** `Error`

### 11. interrupt

- **Target:** `gix.Interrupt`
- **Similarity:** 0.12
- **Dependents:** 0
- **Priority Score:** 172008.8
- **Functions:** 3/15 matched (target 3)
- **Missing functions:** `deregister`, `with_reset`, `auto_deregister`, `drop`, `init_handler`, `new`, `into_inner`, `inner`, `next`, `read`, `fill_buf`, `consume`
- **Types:** 0/5 matched (target 1)
- **Missing types:** `Deregister`, `AutoDeregister`, `Iter`, `Item`, `Read`

### 12. create

- **Target:** `gix.Create [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 131310.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `at`, `as_mut`, `drop`, `write_file`, `create_dir`, `into`, `key`, `bool`
- **Types:** 0/5 matched (target 9)
- **Missing types:** `Error`, `Kind`, `PathCursor`, `NewDir`, `Options`

### 13. lib

- **Target:** `gix.Gix`
- **Similarity:** 0.11
- **Dependents:** 0
- **Priority Score:** 121508.9
- **Functions:** 3/11 matched (target 3)
- **Missing functions:** `discover_with_environment_overrides`, `open_with_environment_overrides`, `init_bare`, `prepare_clone_bare`, `prepare_clone`, `open_opts_with_git_binary_config`, `open_opts`, `is_dir_to_mode`
- **Types:** 0/4 matched (target 7)
- **Missing types:** `RefStore`, `OdbHandle`, `OdbHandleArc`, `Config`

### 14. commit

- **Target:** `gix.Commit`
- **Similarity:** 0.07
- **Dependents:** 0
- **Priority Score:** 111409.3
- **Functions:** 1/10 matched (target 2)
- **Missing functions:** `from`, `format_with_dirty_suffix`, `names`, `traverse_first_parent`, `max_candidates`, `id_as_fallback`, `try_format`, `try_resolve_with_cache`, `try_resolve`
- **Types:** 2/4 matched (target 11)
- **Missing types:** `Error`, `Platform`

### 15. filter

- **Target:** `gix.Filter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 101010.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `options`, `new`, `into_parts`, `convert_to_git`, `convert_to_worktree`, `worktree_file_to_object`, `driver_context_mut`, `extract_drivers`
- **Types:** 0/2 matched (target 3)
- **Missing types:** `Error`, `Pipeline`

### 16. discover

- **Target:** `gix.Discover [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 60610.0
- **Functions:** 0/5 matched (target 0)
- **Missing functions:** `discover`, `discover_opts`, `discover_with_environment_overrides`, `discover_with_environment_overrides_opts`, `apply_additional_environment`
- **Types:** 0/1 matched (target 4)
- **Missing types:** `Error`

### 17. types

- **Target:** `gix.Types`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 41810.0
- **Functions:** 0/1 matched (target 21)
- **Missing functions:** `drop`
- **Types:** 14/17 matched (target 15)
- **Missing types:** `Id`, `Tree`, `AttributeStack`

### 18. env

- **Target:** `gix.Env`
- **Similarity:** 0.13
- **Dependents:** 0
- **Priority Score:** 40708.7
- **Functions:** 3/6 matched (target 3)
- **Missing functions:** `args_os`, `args_os_opt`, `os_str_to_bstring`
- **Types:** 0/1 matched (target 11)
- **Missing types:** `Error`

### 19. util

- **Target:** `gix.Util`
- **Similarity:** 0.08
- **Dependents:** 0
- **Priority Score:** 40609.2
- **Functions:** 1/4 matched
- **Missing functions:** `deref`, `from`, `parallel_iter_drop`
- **Types:** 1/2 matched (target 1)
- **Missing types:** `Target`

### 20. init

- **Target:** `gix.Init [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 30310.0
- **Functions:** 0/2 matched (target 0)
- **Missing functions:** `init`, `init_opts`
- **Types:** 0/1 matched (target 6)
- **Missing types:** `Error`

### 21. shallow

- **Target:** `gix.Shallow [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 20210.0
- **Functions:** 0/0 matched (target 2)
- **Missing functions:** _none_
- **Types:** 0/2 matched (target 6)
- **Missing types:** `CommitsStorage`, `Commits`

### 22. ext.rev_spec

- **Target:** `ext.RevSpec`
- **Similarity:** 0.55
- **Dependents:** 0
- **Priority Score:** 10204.5
- **Functions:** 1/1 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched
- **Missing types:** `RevSpecExt`

### 23. mailmap

- **Target:** `gix.Mailmap`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 6)
- **Missing types:** `Error`

### 24. push

- **Target:** `gix.Push`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched
- **Missing types:** `Default`

### 25. tag

- **Target:** `gix.Tag`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 5)
- **Missing types:** `Error`

### 26. submodule.errors

- **Target:** `submodule.Errors`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 30)
- **Missing types:** `Error`

### 27. parse.types

- **Target:** `parse.Types`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 300.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 3/3 matched
- **Missing types:** _none_

### 28. prelude

- **Target:** `gix.Prelude [STUB]`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 0.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 1)
- **Missing types:** _none_

## Success Criteria

For each file to be considered "complete":
- **Similarity ≥ 0.85** (Excellent threshold)
- All public APIs ported
- All tests ported
- Documentation ported
- port-lint header present

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

