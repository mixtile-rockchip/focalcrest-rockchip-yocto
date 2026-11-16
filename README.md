# focalcrest-rockchip-yocto

Yocto project for Mixtile Rockchip boards. It builds a headless base image
from one distro and one self-maintained layer.

## Build

```sh
git clone --recurse-submodules https://github.com/mixtile-rockchip/focalcrest-rockchip-yocto.git focalcrest-rockchip-yocto
cd focalcrest-rockchip-yocto
. ./setup-env.sh                    # defaults to build-edge2
bitbake focalcrest-image-base
```

Artifacts land in `build-edge2/tmp/deploy/images/<MACHINE>/`.

## Layers

| Path | Origin | Branch |
|---|---|---|
| `layers/bitbake` | git.openembedded.org/bitbake | 2.18 |
| `layers/openembedded-core` | git.openembedded.org/openembedded-core | wrynose |
| `layers/meta-openembedded` | github.com/openembedded/meta-openembedded | wrynose |
| `layers/meta-arm` | git.yoctoproject.org/meta-arm | wrynose |
| `layers/meta-rockchip` | git.yoctoproject.org/meta-rockchip | wrynose |
| `layers/meta-focalcrest` | this repository | — |

Upstream layers are pinned as submodules; `git submodule status` is the current
baseline.

## Image

| Image | Purpose |
|---|---|
| `focalcrest-image-base` | Headless base system: SSH, ADB, networking, storage and diagnostics |

The base image provides SSH/ADB access, the base package group and automatic
root partition/filesystem growth. Images are published as GitHub releases by
`.github/workflows/build.yml`.

## Supported machines

| MACHINE | SoC |
|---|---|
| `rk3568-mixtile-edge2` | RK3568 |
| `rk3588-mixtile-blade3` | RK3588 |
| `rk3588-mixtile-core3588e` | RK3588 |
