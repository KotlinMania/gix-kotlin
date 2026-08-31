# Immediate Actions - High-Value Files

Based on AST analysis, here are the concrete next steps.

## Summary

- **Files Present:** 28/176 (15.9%)
- **Function parity:** 20/1227 matched (target 99) — 1.6%
- **Class/type parity:** 22/335 matched (target 152) — 6.6%
- **Combined symbol parity:** 42/1562 matched (target 251) — 2.7%
- **Average inline-code cosine:** 0.26 (function body across 25 matched files)
- **Average documentation cosine:** 0.45 (doc text across 25 matched files)
- **Cheat-zeroed Files:** 11
- **Critical Issues:** 23 files with <0.60 function similarity

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
- **Similarity:** 0.00 (needs 85% improvement)
- **Dependencies:** 17
- **Priority Score:** 17040510.0
- **Functions:** 1/2 matched
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 1)
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

- **Target:** `ext.ObjectId [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 17
- **Priority Score:** 17040510.0
- **Functions:** 1/2 matched
- **Missing functions:** `ancestors`
- **Types:** 0/3 matched (target 1)
- **Missing types:** `Sealed`, `AncestorsIter`, `ObjectIdExt`

### 3. ext.tree

- **Target:** `ext.Tree`
- **Similarity:** 0.51
- **Dependents:** 5
- **Priority Score:** 5060705.0
- **Functions:** 1/2 matched (target 9)
- **Missing functions:** `traverse`
- **Types:** 0/5 matched (target 6)
- **Missing types:** `Sealed`, `TreeIterExt`, `TreeEntryRefExt`, `TreeEntryExt`, `TreeDiffChangeExt`

### 4. gix.attribute_stack

- **Target:** `gix.AttributeStack`
- **Similarity:** 0.07
- **Dependents:** 2
- **Priority Score:** 2060709.2
- **Functions:** 1/6 matched (target 2)
- **Missing functions:** `new`, `detach`, `deref`, `deref_mut`, `at_entry`
- **Types:** 0/1 matched
- **Missing types:** `Target`

### 5. gix.path

- **Target:** `gix.Path`
- **Similarity:** 0.00
- **Dependents:** 2
- **Priority Score:** 2010110.0
- **Functions:** 0/1 matched (target 6)
- **Missing functions:** `install_dir`
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_

### 6. gix.state

- **Target:** `gix.State [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 2
- **Priority Score:** 2000110.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 1/1 matched (target 2)
- **Missing types:** _none_

### 7. gix.id

- **Target:** `gix.Id`
- **Similarity:** 0.11
- **Dependents:** 1
- **Priority Score:** 1162008.9
- **Functions:** 4/18 matched (target 19)
- **Missing functions:** `object`, `header`, `try_object`, `try_header`, `calculate_auto_hex_len`, `deref`, `ancestors`, `hash`, `partial_cmp`, `eq`, `fmt`, `as_ref`, `from`, `size_of_oid`
- **Types:** 0/2 matched (target 4)
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

### 9. gix.progress

- **Target:** `gix.Progress [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 1
- **Priority Score:** 1000010.0
- **Functions:** 0/0 matched (target 4)
- **Missing functions:** _none_
- **Types:** 0/0 matched (target 2)
- **Missing types:** _none_

### 10. object.mod

- **Target:** `objs.Kind [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 232310.0
- **Functions:** 0/22 matched (target 0)
- **Missing functions:** `attach`, `fmt`, `from_data`, `into_blob`, `into_tree`, `into_commit`, `into_tag`, `try_into_commit`, `try_into_tag`, `try_into_tree`, `try_into_blob`, `detached`, `detach`, `to_commit_ref`, `try_to_commit_ref`, `to_commit_ref_iter`, `try_to_commit_ref_iter`, `to_tag_ref_iter`, `try_to_tag_ref_iter`, `to_tag_ref`, `try_to_tag_ref`, `id`
- **Types:** 0/1 matched
- **Missing types:** `Error`

### 11. gix.interrupt

- **Target:** `gix.Interrupt`
- **Similarity:** 0.12
- **Dependents:** 0
- **Priority Score:** 172008.8
- **Functions:** 3/15 matched (target 4)
- **Missing functions:** `deregister`, `with_reset`, `auto_deregister`, `drop`, `init_handler`, `new`, `into_inner`, `inner`, `next`, `read`, `fill_buf`, `consume`
- **Types:** 0/5 matched (target 2)
- **Missing types:** `Deregister`, `AutoDeregister`, `Iter`, `Item`, `Read`

### 12. gix.create

- **Target:** `gix.Create [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 131310.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `at`, `as_mut`, `drop`, `write_file`, `create_dir`, `into`, `key`, `bool`
- **Types:** 0/5 matched (target 9)
- **Missing types:** `Error`, `Kind`, `PathCursor`, `NewDir`, `Options`

### 13. gix.lib

- **Target:** `gix.Gix [STUB]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 121510.0
- **Functions:** 3/11 matched (target 8)
- **Missing functions:** `discover_with_environment_overrides`, `open_with_environment_overrides`, `init_bare`, `prepare_clone_bare`, `prepare_clone`, `open_opts_with_git_binary_config`, `open_opts`, `is_dir_to_mode`
- **Types:** 0/4 matched (target 9)
- **Missing types:** `RefStore`, `OdbHandle`, `OdbHandleArc`, `Config`

### 14. gix.commit

- **Target:** `gix.Commit`
- **Similarity:** 0.07
- **Dependents:** 0
- **Priority Score:** 111409.3
- **Functions:** 1/10 matched (target 2)
- **Missing functions:** `from`, `format_with_dirty_suffix`, `names`, `traverse_first_parent`, `max_candidates`, `id_as_fallback`, `try_format`, `try_resolve_with_cache`, `try_resolve`
- **Types:** 2/4 matched (target 11)
- **Missing types:** `Error`, `Platform`

### 15. gix.filter

- **Target:** `gix.Filter [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 101010.0
- **Functions:** 0/8 matched (target 0)
- **Missing functions:** `options`, `new`, `into_parts`, `convert_to_git`, `convert_to_worktree`, `worktree_file_to_object`, `driver_context_mut`, `extract_drivers`
- **Types:** 0/2 matched (target 3)
- **Missing types:** `Error`, `Pipeline`

### 16. gix.discover

- **Target:** `gix.Discover [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 60610.0
- **Functions:** 0/5 matched (target 0)
- **Missing functions:** `discover`, `discover_opts`, `discover_with_environment_overrides`, `discover_with_environment_overrides_opts`, `apply_additional_environment`
- **Types:** 0/1 matched (target 4)
- **Missing types:** `Error`

### 17. gix.types

- **Target:** `gix.Types`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 41810.0
- **Functions:** 0/1 matched (target 26)
- **Missing functions:** `drop`
- **Types:** 14/17 matched (target 16)
- **Missing types:** `Id`, `Tree`, `AttributeStack`

### 18. gix.env

- **Target:** `gix.Env`
- **Similarity:** 0.13
- **Dependents:** 0
- **Priority Score:** 40708.7
- **Functions:** 3/6 matched (target 5)
- **Missing functions:** `args_os`, `args_os_opt`, `os_str_to_bstring`
- **Types:** 0/1 matched (target 12)
- **Missing types:** `Error`

### 19. gix.util

- **Target:** `gix.Util`
- **Similarity:** 0.08
- **Dependents:** 0
- **Priority Score:** 40609.2
- **Functions:** 1/4 matched (target 5)
- **Missing functions:** `deref`, `from`, `parallel_iter_drop`
- **Types:** 1/2 matched
- **Missing types:** `Target`

### 20. gix.init

- **Target:** `gix.Init [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 30310.0
- **Functions:** 0/2 matched (target 0)
- **Missing functions:** `init`, `init_opts`
- **Types:** 0/1 matched (target 6)
- **Missing types:** `Error`

### 21. gix.shallow

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

### 23. gix.push

- **Target:** `gix.Push [ZERO]`
- **Similarity:** 0.00
- **Dependents:** 0
- **Priority Score:** 10110.0
- **Functions:** 0/0 matched (target 1)
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 2)
- **Missing types:** `Default`

### 24. gix.tag

- **Target:** `gix.Tag`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 5)
- **Missing types:** `Error`

### 25. submodule.errors

- **Target:** `submodule.Errors`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 30)
- **Missing types:** `Error`

### 26. gix.mailmap

- **Target:** `gix.Mailmap`
- **Similarity:** 1.00
- **Dependents:** 0
- **Priority Score:** 10100.0
- **Functions:** 0/0 matched
- **Missing functions:** _none_
- **Types:** 0/1 matched (target 6)
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

### 28. gix.prelude

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

