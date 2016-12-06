
$cwd = $PSScriptRoot

pushd $cwd

rm -rec expected
cp -rec output expected
popd